package com.twschool.practice;

import java.math.BigDecimal;

public class OutsideAirportTaxStrategy extends TaxStrategy {

    private final ItemValue itemValue;

    public OutsideAirportTaxStrategy(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public BigDecimal localTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (!itemValue.getCategory().isBookFoodAndMedicalCategory()) {
            localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }
    
    @Override
    public BigDecimal importedTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (itemValue.getFrom() == ItemFrom.IMPORTED) {
            localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.05")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }
    
}
