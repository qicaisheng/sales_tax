package com.twschool.practice;

import com.twschool.practice.taxstrategy.AirportForeignPassportTaxStrategy;
import com.twschool.practice.taxstrategy.AirportLocalPassportTaxStrategy;
import com.twschool.practice.taxstrategy.OutsideAirportTaxStrategy;
import com.twschool.practice.taxstrategy.TaxStrategy;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void should_return_AirportLocalPassportTaxStrategy_given_store_not_in_airport() {
        Store store = new Store(true);
        Passport passport = new Passport("123456789012345");

        TaxStrategy taxStrategy = TaxStrategy.selectTaxStrategy(store, passport);

        Assert.assertEquals(AirportLocalPassportTaxStrategy.class, taxStrategy.getClass());
    }

}