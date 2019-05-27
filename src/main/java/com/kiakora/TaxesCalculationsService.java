package com.kiakora;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Singleton
public class TaxesCalculationsService {

    public static final BigDecimal NOT_TAXABLE_VALUE = new BigDecimal(5550);
    private final TaxTableConfiguration taxTableConfiguration;


    public TaxesCalculationsService(TaxTableConfiguration taxTableConfiguration) {
        this.taxTableConfiguration = taxTableConfiguration;
    }

    public KuantoRentaResponse calculate(KuantoRentaRequest request) {
        BigDecimal toPayInRegion = calculateFor(request, request.getRegion());
        BigDecimal toPayInCountry = calculateFor(request, "spain");
        BigDecimal alreadyPaid130 = request.getNetAmount().multiply(new BigDecimal(0.2));
        BigDecimal totalToPay = toPayInRegion.add(toPayInCountry);
        return new KuantoRentaResponse(
            totalToPay,
            alreadyPaid130,
            totalToPay.subtract(alreadyPaid130),
            request.getNetAmount().subtract(totalToPay),
            totalToPay.multiply(new BigDecimal(100)).divide(request.getNetAmount(), 2, RoundingMode.HALF_UP)
        );
    }

    private BigDecimal calculateFor(KuantoRentaRequest request, String region) {
        TaxTableConfiguration.TaxTable taxTable = taxTableConfiguration.getTaxTableByYearAndRegion(request.getYear(), region);
        return calculateToPaidFor(taxTable, request.getNetAmountWithoutHardExpenses());
    }

    private BigDecimal calculateToPaidFor(TaxTableConfiguration.TaxTable taxTable, BigDecimal netAmount) {
        List<Double> ranges = taxTable.getRanges();
        BigDecimal amount = netAmount;
        BigDecimal totalToPay = new BigDecimal(0);
        for(int i = 0; i < ranges.size(); i++){
            Double range = new Double(ranges.get(i));
            Double rangeLimit = range;
            if (i > 0){
                rangeLimit = rangeLimit - ranges.get(i - 1);
            }
            BigDecimal partialAmount = amount.intValue() >= rangeLimit ? new BigDecimal(rangeLimit) : amount;
            BigDecimal tax = taxTable.getValueFor(range);
            totalToPay = totalToPay.add(partialAmount.subtract(i == 0 ? NOT_TAXABLE_VALUE : new BigDecimal(0)).multiply(tax).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP));
            amount = amount.intValue() == partialAmount.intValue() ? new BigDecimal(0) : amount.subtract(partialAmount);
        }
        return totalToPay;
    }


}
