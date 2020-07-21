package com.twschool.practice;

import java.math.BigDecimal;

public class AirportLocalPassportTaxStrategy extends TaxStrategy {
    
    private final OutsideAirportTaxStrategy outsideAirportTaxStrategy = new OutsideAirportTaxStrategy();

    @Override
    protected boolean match(Store store, Passport passport) {
        return store.isInAirport() && !passport.isForeignPassport();
    }
    
    @Override
    public BigDecimal basicTax(ItemValue itemValue) {
        return outsideAirportTaxStrategy.basicTax(itemValue);
    }

    @Override
    public BigDecimal importedTax(ItemValue itemValue) {
        return outsideAirportTaxStrategy.importedTax(itemValue);
    }
}
