package com.twschool.practice;

import java.math.BigDecimal;

public class ItemValue {
    private final ItemCategory category;
    private final ItemFrom from;
    private final int amount;
    private final BigDecimal unitPrice;

    public ItemValue(ItemCategory category, ItemFrom from, int amount, BigDecimal unitPrice) {
        this.category = category;
        this.from = from;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public ItemFrom getFrom() {
        return from;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
