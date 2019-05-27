package com.kiakora;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Singleton
public class TaxTableConfiguration {

    private final DataSource dataSource;

    private TaxTable taxTable;

    public TaxTableConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TaxTable getTaxTableByYearAndRegion(int year, String region){
        ResultSet resultSet = null;
        try (
            Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select values from irpf where region_id = ? and year = ?")
        ){
            preparedStatement.setString(1, region.toLowerCase());
            preparedStatement.setInt(2, year);
            resultSet = preparedStatement.executeQuery();
            Map<String, Object> ranges = new LinkedHashMap<>();
            if(resultSet.next()){
                ranges = new ObjectMapper().readValue(resultSet.getString(1), Map.class);
            }
            return new TaxTable(ranges);
        } catch (SQLException | IOException e){
            return null;
        } finally {
            if (resultSet != null){
                try { resultSet.close(); } catch (SQLException e) { }
            }
        }
    }

    static class TaxTable {
        private final Map<Double, Double> ranges;

        public TaxTable(Map<String, Object> ranges) {
            this.ranges = new TreeMap<>();
            for(String range: ranges.keySet()){
                this.ranges.putIfAbsent(Double.parseDouble(range), Double.parseDouble(ranges.get(range).toString()));
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
