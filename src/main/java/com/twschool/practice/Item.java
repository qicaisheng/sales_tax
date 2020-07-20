package com.twschool.practice;

import java.math.BigDecimal;

public class Item {
    private final ItemCategory category;
    private final ItemFrom from;
    private final int amount;
    private final BigDecimal unitPrice;

    public Item(ItemCategory category, ItemFrom from, int amount, BigDecimal unitPrice) {
        this.category = category;
        this.from = from;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public BigDecimal localTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (!category.isBookFoodAndMedicalCategory()) {
            localTax = unitPrice.multiply(new BigDecimal("0.10"));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal importedTax() {
        BigDecimal localTax = BigDecimal.ZERO;
        if (from == ItemFrom.IMPORTED) {
            localTax = unitPrice.multiply(new BigDecimal("0.05"));
        }
        return localTax.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal totalPrice() {
        return unitPrice.add(localTax()).add(importedTax()).multiply(BigDecimal.valueOf(amount));
    }
}
