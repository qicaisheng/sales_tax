package com.twschool.practice;

import java.math.BigDecimal;

public abstract class TaxStrategy {

    private final ItemValue itemValue;

    public TaxStrategy(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    public abstract BigDecimal localTax(ItemValue itemValue);

    public abstract BigDecimal importedTax();

    public BigDecimal tax() {
        return importedTax().add(localTax(getItemValue()));
    }

    public ItemValue getItemValue() {
        return itemValue;
    }
}
