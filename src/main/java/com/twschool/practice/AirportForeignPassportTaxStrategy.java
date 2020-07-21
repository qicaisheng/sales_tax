package com.twschool.practice;

import java.math.BigDecimal;

public class AirportForeignPassportTaxStrategy extends TaxStrategy {
    
    @Override
    protected boolean match(Store store, Passport passport) {
        return store.isInAirport() && passport.isForeignPassport();
    }

    @Override
    public BigDecimal localTax(ItemValue itemValue) {
        BigDecimal localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    @Override
    public BigDecimal importedTax(ItemValue itemValue) {
        return new BigDecimal("0.00");
    }
    
}
