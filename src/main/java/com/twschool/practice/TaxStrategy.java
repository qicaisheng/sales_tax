package com.twschool.practice;

import java.math.BigDecimal;

public abstract class TaxStrategy {
    public abstract BigDecimal localTax();

    public abstract BigDecimal importedTax();

    public BigDecimal tax() {
        return importedTax().add(localTax());
    }

}
