package com.kiakora;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class KuantoRentaFunctionTest {

    @Inject
    KuantoRentaClient client;

    @Test
    public void returnsTheTaxesAlreadyPaid() throws Exception {
        KuantoRentaRequest body = new KuantoRentaRequest();
        body.setRegion("Madrid");
        body.setRevenue(new BigDecimal(40000));
        body.setExpenses(new BigDecimal(3000));
        assertEquals(7400, client.apply(body).blockingGet().getAlreadyPaid130().doubleValue());
    }

    @Test
    public void returnsTheTotalToPayBasedOnRegion() throws Exception {
        KuantoRentaRequest body = new KuantoRentaRequest();
        body.setRegion("Madrid");
        body.setRevenue(new BigDecimal(40000));
        body.setExpenses(new BigDecimal(3000));
        assertEquals(7490.77, client.apply(body).blockingGet().getTotalToPay().doubleValue());
    }

    @Test
    public void returnsTheTotalBenefitsBasedOnRegion() throws Exception {
        KuantoRentaRequest body = new KuantoRentaRequest();
        body.setRegion("Madrid");
        body.setRevenue(new BigDecimal(40000));
        body.setExpenses(new BigDecimal(3000));
        assertEquals(29509.23, client.apply(body).blockingGet().getProfit().doubleValue());
    }

    @Test
    public void returnsThePendingToPayValueBasedOnRegion() throws Exception {
        KuantoRentaRequest body = new KuantoRentaRequest();
        body.setRegion("Madrid");
        body.setRevenue(new BigDecimal(40000));
        body.setExpenses(new BigDecimal(3000));
        assertEquals(90.77, round(client.apply(body).blockingGet().getPendingToPaid()));
    }


    @Test
    public void returnsTheTotalRateOfTaxesPaidBasedOnRegion() throws Exception {
        KuantoRentaRequest body = new KuantoRentaRequest();
        body.setRegion("Madrid");
        body.setRevenue(new BigDecimal(40000));
        body.setExpenses(new BigDecimal(3000));
        assertEquals(20.25, round(client.apply(body).blockingGet().getTaxRatePaid()));
    }

    private double round(BigDecimal pendingToPaid) {
        return pendingToPaid.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
