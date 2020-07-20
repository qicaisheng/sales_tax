package com.twschool.practice;

import java.math.BigDecimal;

public class AirportForeignPassportTaxStrategy extends TaxStrategy {

    private final ItemValue itemValue;

    public AirportForeignPassportTaxStrategy(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public BigDecimal localTax() {
        BigDecimal localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    @Override
    public BigDecimal importedTax() {
        return new BigDecimal("0.00");
    }
    
}
