package com.twschool.practice;

import java.math.BigDecimal;

public class OutsideAirportTaxStrategy extends TaxStrategy {

    public OutsideAirportTaxStrategy(ItemValue itemValue) {
        super(itemValue);
    }

    @Override
    public BigDecimal localTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (!getItemValue().getCategory().isBookFoodAndMedicalCategory()) {
            localTax = getItemValue().getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(getItemValue().getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }
    
    @Override
    public BigDecimal importedTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (getItemValue().getFrom() == ItemFrom.IMPORTED) {
            localTax = getItemValue().getUnitPrice().multiply(new BigDecimal("0.05")).multiply(BigDecimal.valueOf(getItemValue().getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }
    
}
