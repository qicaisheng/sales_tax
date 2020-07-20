package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AirportForeignPassportTexStrategyTest {

    @Test
    public void should_calculate_local_tax_given_items() {
        AirportForeignPassportTexStrategy airportForeignPassportTexStrategy = new AirportForeignPassportTexStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));
        
        BigDecimal tax = airportForeignPassportTexStrategy.localTax();

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
    
    @Test
    public void should_calculate_imported_tax_given_items() {
        AirportForeignPassportTexStrategy airportForeignPassportTexStrategy = new AirportForeignPassportTexStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));

        BigDecimal tax = airportForeignPassportTexStrategy.importedTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_items() {
        AirportForeignPassportTexStrategy airportForeignPassportTexStrategy = new AirportForeignPassportTexStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49")));

        BigDecimal tax = airportForeignPassportTexStrategy.tax();

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
}