package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxStrategyTest {

    @Test
    public void should_return_AirportForeignPassportTaxStrategy_given_airport_store_and_foreign_passport() {
        Store store = new Store(true);
        Passport passport = new Passport("123456789012345678");
        
        TaxStrategy taxStrategy = TaxStrategy.selectTaxStrategy(store, passport);

        Assert.assertEquals(AirportForeignPassportTaxStrategy.class, taxStrategy.getClass());
    }

    @Test
    public void should_return_OutsideAirportTaxStrategy_given_store_not_in_airport() {
        Store store = new Store(false);
        Passport passport = new Passport("123456789012345678");

        TaxStrategy taxStrategy = TaxStrategy.selectTaxStrategy(store, passport);

        Assert.assertEquals(OutsideAirportTaxStrategy.class, taxStrategy.getClass());
    }
}