package com.twschool.practice;

import com.twschool.practice.taxstrategy.AirportForeignPassportTaxStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class AirportForeignPassportTaxStrategyTest {

    @Test
    public void should_calculate_local_tax_given_items() {
        ItemValue itemValue = new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49"));
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy();
        
        BigDecimal tax = airportForeignPassportTaxStrategy.basicTax(itemValue);

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
    
    @Test
    public void should_calculate_imported_tax_given_items() {
        ItemValue itemValue = new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49"));
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy();

        BigDecimal tax = airportForeignPassportTaxStrategy.importedTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_items() {
        ItemValue itemValue = new ItemValue(ItemCategory.BOOK, ItemFrom.IMPORTED, 1, new BigDecimal("12.49"));
        AirportForeignPassportTaxStrategy airportForeignPassportTaxStrategy = new AirportForeignPassportTaxStrategy();

        BigDecimal tax = airportForeignPassportTaxStrategy.tax(itemValue);

        Assert.assertEquals(new BigDecimal("1.25"), tax);
    }
}