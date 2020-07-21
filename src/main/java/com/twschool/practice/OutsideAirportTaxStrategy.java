package com.twschool.practice;

import java.math.BigDecimal;

public class OutsideAirportTaxStrategy extends TaxStrategy {

    public static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.10");
    public static final BigDecimal IMPORTED_TAX_RATE = new BigDecimal("0.05");

    @Override
    protected boolean match(Store store, Passport passport) {
        return !store.isInAirport();
    }

    @Override
    public BigDecimal basicTax(ItemValue itemValue) {
        BigDecimal localTax = BigDecimal.ZERO;
        if (!itemValue.getCategory().isBookFoodAndMedicalCategory()) {
            localTax = itemValue.getUnitPrice().multiply(BASIC_TAX_RATE).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }
    
    @Override
    public BigDecimal importedTax(ItemValue itemValue) {
        BigDecimal localTax = BigDecimal.ZERO;
        if (itemValue.getFrom() == ItemFrom.IMPORTED) {
            localTax = itemValue.getUnitPrice().multiply(IMPORTED_TAX_RATE).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

}
