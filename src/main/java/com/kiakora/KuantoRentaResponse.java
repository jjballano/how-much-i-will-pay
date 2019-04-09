package com.kiakora;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class KuantoRentaResponse implements Serializable {

    private BigDecimal totalToPay;
    private BigDecimal alreadyPaid130;
    private BigDecimal pendingToPaid;
    private BigDecimal profit;
    private BigDecimal taxRatePaid;

    public KuantoRentaResponse(){}

    public KuantoRentaResponse(BigDecimal totalToPay, BigDecimal alreadyPaid130, BigDecimal pendingToPaid, BigDecimal profit, BigDecimal taxRatePaid) {
        this.totalToPay = totalToPay;
        this.alreadyPaid130 = alreadyPaid130;
        this.pendingToPaid = pendingToPaid;
        this.profit = profit;
        this.taxRatePaid = taxRatePaid;
    }

    public static KuantoRentaResponse empty(){
        return new KuantoRentaResponse();
    }

    public BigDecimal getTotalToPay() {
        return totalToPay.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTotalToPay(BigDecimal totalToPay) {
        this.totalToPay = totalToPay;
    }

    public BigDecimal getAlreadyPaid130() {
        return alreadyPaid130.setScale(2, RoundingMode.HALF_UP);
    }

    public void setAlreadyPaid130(BigDecimal alreadyPaid130) {
        this.alreadyPaid130 = alreadyPaid130;
    }

    public BigDecimal getPendingToPaid() {
        return pendingToPaid.setScale(2, RoundingMode.HALF_UP);
    }

    public void setPendingToPaid(BigDecimal pendingToPaid) {
        this.pendingToPaid = pendingToPaid;
    }

    public BigDecimal getProfit() {
        return profit.setScale(2, RoundingMode.HALF_UP);
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getTaxRatePaid() {
        return taxRatePaid.setScale(2, RoundingMode.HALF_UP);
    }

    public void setTaxRatePaid(BigDecimal taxRatePaid) {
        this.taxRatePaid = taxRatePaid;
    }
}

