package com.twschool.practice;

import java.math.BigDecimal;

public class Item {
    private final ItemValue itemValue;
    private TaxStrategy taxStrategy;

    public Item(ItemValue itemValue) {
        this.itemValue = itemValue;
    }

    public Item(ItemValue itemValue, OutsideAirportTaxStrategy taxStrategy) {
        this.itemValue = itemValue;
        this.taxStrategy = taxStrategy;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public BigDecimal localTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (!itemValue.getCategory().isBookFoodAndMedicalCategory()) {
            localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.10")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal importedTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (itemValue.getFrom() == ItemFrom.IMPORTED) {
            localTax = itemValue.getUnitPrice().multiply(new BigDecimal("0.05")).multiply(BigDecimal.valueOf(itemValue.getAmount()));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal totalPrice() {
        BigDecimal price = itemValue.getUnitPrice().multiply(BigDecimal.valueOf(itemValue.getAmount()));
        return price.add(taxStrategy.tax());
    }

    public String describe() {
        String itemFrom = itemValue.getFrom() == ItemFrom.IMPORTED ? "imported " : ""; 
        return String.format("%d %s%s: %s", itemValue.getAmount(), itemFrom, itemValue.getCategory().toString(), totalPrice().toString());
    }

    public BigDecimal tax() {
        return importedTax().add(localTax());
    }
}
