package com.twschool.practice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class TaxStrategy {
    
    public abstract BigDecimal basicTax(ItemValue itemValue);

    public abstract BigDecimal importedTax(ItemValue itemValue);

    public BigDecimal tax(ItemValue itemValue) {
        return importedTax(itemValue).add(basicTax(itemValue));
    }

    protected abstract boolean match(Store store, Passport passport);

    public static TaxStrategy selectTaxStrategy(Store store, Passport passport) {
        return getTaxStrategies().stream().filter(taxStrategy -> taxStrategy.match(store, passport)).findFirst().orElse(new OutsideAirportTaxStrategy());
    }

    private static List<TaxStrategy> getTaxStrategies() {
        return Arrays.asList(new AirportForeignPassportTaxStrategy(), new OutsideAirportTaxStrategy(), new AirportLocalPassportTaxStrategy());
    }
}
