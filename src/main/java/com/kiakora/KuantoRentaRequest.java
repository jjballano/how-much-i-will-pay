package com.kiakora;

import java.io.Serializable;
import java.math.BigDecimal;

public class KuantoRentaRequest implements Serializable {

    private String region;
    private BigDecimal revenue;
    private BigDecimal expenses;

    public KuantoRentaRequest() {}

    public KuantoRentaRequest(String region, BigDecimal revenue, BigDecimal expenses) {
        this.region = region;
        this.revenue = revenue;
        this.expenses = expenses;
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
}

