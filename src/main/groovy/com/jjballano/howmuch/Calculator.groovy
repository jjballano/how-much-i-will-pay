package com.jjballano.howmuch

import groovy.transform.CompileStatic
import io.micronaut.context.annotation.Property

@CompileStatic
class Calculator {

    @Property(name = 'irpf.tables.2018')
    protected Map irpfTables

    Report calculate(RequestCalculation request){
        calculateFor((List)irpfTables[request.city?.toLowerCase()], request.revenue, request.expenses)
    }

    private BigDecimal calculateToPaidFor(List<Map> irpfRanges, BigDecimal amount){
        BigDecimal totalToPaid = 0
        BigDecimal remainAmount = amount

        irpfRanges.eachWithIndex { Map<BigDecimal, BigDecimal> rangeLimitEntry, int index ->
            BigDecimal rangeLimit = rangeLimitEntry.keySet()[0]
            if (index > 0){
                rangeLimit -= (BigDecimal)irpfRanges[index - 1].keySet()[0]
            }
            BigDecimal partialAmount = remainAmount >= rangeLimit ? rangeLimit : remainAmount
            BigDecimal value = rangeLimitEntry.values()[0]
            totalToPaid += ((partialAmount - (index == 0 ? 5550 : 0)) * value / 100)
            remainAmount -= partialAmount
        }

        totalToPaid
    }

    private Report calculateFor(List cityTables, BigDecimal revenue, BigDecimal expenses){
        Report report = new Report(revenue: revenue, expenses: expenses)

        List spainTables = irpfTables['spain']

        BigDecimal netAmount = revenue - expenses

        BigDecimal hardExpenses = netAmount * 0.05

        report.alreadyPaid130 = netAmount * 0.20

        netAmount -= hardExpenses

        report.totalToPay += calculateToPaidFor(spainTables, netAmount)
        report.totalToPay += calculateToPaidFor(cityTables, netAmount)

        report
    }
}