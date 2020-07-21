package com.twschool.practice;

import com.twschool.practice.taxstrategy.TaxStrategy;

import java.math.BigDecimal;

public class Item {
    private final ItemValue itemValue;
    private final TaxStrategy taxStrategy;

    public Item(ItemValue itemValue, TaxStrategy taxStrategy) {
        this.itemValue = itemValue;
        this.taxStrategy = taxStrategy;
    }

    public BigDecimal totalPrice() {
        BigDecimal price = itemValue.prices();
        return price.add(tax());
    }

    public BigDecimal tax() {
        return taxStrategy.tax(itemValue);
    }

    public String describe() {
        String itemFrom = itemValue.getFrom() == ItemFrom.IMPORTED ? "imported " : ""; 
        return String.format("%d %s%s: %s", itemValue.getAmount(), itemFrom, itemValue.getCategory().toString(), totalPrice().toString());
    }
}
