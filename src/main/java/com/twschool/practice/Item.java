package com.twschool.practice;

import java.math.BigDecimal;

public class Item {
    private final ItemValue itemValue;
    private final TaxStrategy taxStrategy;

    public Item(TaxStrategy taxStrategy, ItemValue itemValue) {
        this.itemValue = itemValue;
        this.taxStrategy = taxStrategy;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public ItemValue getItemValue() {
        return itemValue;
    }

    public BigDecimal totalPrice() {
        BigDecimal price = itemValue.getUnitPrice().multiply(BigDecimal.valueOf(itemValue.getAmount()));
        return price.add(taxStrategy.tax(getItemValue()));
    }

    public String describe() {
        String itemFrom = itemValue.getFrom() == ItemFrom.IMPORTED ? "imported " : ""; 
        return String.format("%d %s%s: %s", itemValue.getAmount(), itemFrom, itemValue.getCategory().toString(), totalPrice().toString());
    }
}
