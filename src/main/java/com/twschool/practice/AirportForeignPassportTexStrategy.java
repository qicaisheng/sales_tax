package com.twschool.practice;

import java.math.BigDecimal;

public class AirportForeignPassportTexStrategy {

    private final ItemValue itemValue;

    public AirportForeignPassportTexStrategy(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    public BigDecimal localTax() {
        BigDecimal localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal importedTax() {
        return new BigDecimal("0.00");
    }

    public BigDecimal tax() {
        return importedTax().add(localTax());
    }

}
