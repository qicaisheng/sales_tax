package com.twschool.practice;

import java.math.BigDecimal;

public class AirportLocalPassportTaxStrategy extends TaxStrategy {
    
    private final OutsideAirportTaxStrategy outsideAirportTaxStrategy = new OutsideAirportTaxStrategy();

    @Override
    protected boolean match(Store store, Passport passport) {
        return store.isInAirport() && !passport.isForeignPassport();
    }
    
    @Override
    public BigDecimal localTax(ItemValue itemValue) {
        return outsideAirportTaxStrategy.localTax(itemValue);
    }

    @Override
    public BigDecimal importedTax(ItemValue itemValue) {
        return outsideAirportTaxStrategy.importedTax(itemValue);
    }
}
