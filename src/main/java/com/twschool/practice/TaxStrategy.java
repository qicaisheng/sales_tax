package com.twschool.practice;

import java.math.BigDecimal;

public abstract class TaxStrategy {

    public TaxStrategy(ItemValue itemValue) {
    }

    public abstract BigDecimal localTax(ItemValue itemValue);

    public abstract BigDecimal importedTax(ItemValue itemValue);

    public BigDecimal tax(ItemValue itemValue) {
        return importedTax(itemValue).add(localTax(itemValue));
    }

}
