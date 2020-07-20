package com.twschool.practice;

import java.math.BigDecimal;

public class AirportForeignPassportTaxStrategy extends TaxStrategy {

    public AirportForeignPassportTaxStrategy(ItemValue itemValue) {
        super(itemValue);
    }

    @Override
    public BigDecimal localTax() {
        BigDecimal localTax = getItemValue().getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(getItemValue().getAmount()));
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    @Override
    public BigDecimal importedTax() {
        return new BigDecimal("0.00");
    }
    
}
