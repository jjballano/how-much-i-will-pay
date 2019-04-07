package com.kiakora;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;

import java.math.BigDecimal;
import java.util.*;

@EachProperty("irpf.tables.2018")
public class TaxTableConfiguration {

    private TaxTable taxTable;
    private final String name;

    public TaxTableConfiguration(@Parameter String name) {
        this.name = name;
    }

    public TaxTable getTaxTable() {
        return taxTable;
    }

    public void setTaxTable(List<Map<Double, Double>> taxTable) {
        this.taxTable = new TaxTable(taxTable);
    }

    static class TaxTable {
        private final Map<Double, Double> ranges;

        public TaxTable(List<Map<Double, Double>> ranges) {
            this.ranges = new TreeMap<>();
            for(Map<Double, Double> range: ranges){
                this.ranges.putIfAbsent(range.keySet().iterator().next(), range.values().iterator().next());
            }
        }

        public List<Double> getRanges(){
            List<Double> rangesOrdered = new ArrayList<>(ranges.keySet());
            rangesOrdered.sort(Comparator.naturalOrder());
            return rangesOrdered;
        }

        public BigDecimal getValueFor(Double amount) {
            Optional<Double> range = getRanges().parallelStream().filter(value -> value >= amount).min(Double::compareTo);
            if (range.isPresent()){
                return new BigDecimal(ranges.get(range.get()));
            }
            return null;
        }

    }
}
