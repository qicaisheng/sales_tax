package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class AirportForeignPassportTaxStrategyTest {

    @Test
    public void should_calculate_local_tax_given_items() {
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));
        
        BigDecimal tax = airportForeignPassportTaxStrategy.localTax(airportForeignPassportTaxStrategy.getItemValue());

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
    
    @Test
    public void should_calculate_imported_tax_given_items() {
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));

        BigDecimal tax = airportForeignPassportTaxStrategy.importedTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_items() {
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));

        BigDecimal tax = airportForeignPassportTaxStrategy.tax();

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
}