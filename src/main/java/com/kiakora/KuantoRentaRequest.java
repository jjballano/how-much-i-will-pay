package com.kiakora;

import io.micronaut.core.annotation.Introspected;

import java.io.Serializable;
import java.math.BigDecimal;

@Introspected
public class KuantoRentaRequest implements Serializable {

    private Integer year;
    private String region;
    private BigDecimal revenue;
    private BigDecimal expenses;

    public KuantoRentaRequest() {}

    public KuantoRentaRequest(Integer year, String region, BigDecimal revenue, BigDecimal expenses) {
        this.region = region;
        this.revenue = revenue;
        this.expenses = expenses;
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }

    public BigDecimal getNetAmount(){
        return this.revenue.subtract(this.expenses);
    }

    public BigDecimal getNetAmountWithoutHardExpenses(){
        return this.revenue.subtract(this.expenses).multiply(new BigDecimal(0.95));
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

