package com.twschool.practice;

import java.math.BigDecimal;

public class Item {
    private final String category;
    private final String from;
    private final int amount;
    private final BigDecimal unitPrice;

    public Item(String category, String from, int amount, BigDecimal unitPrice) {
        this.category = category;
        this.from = from;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public BigDecimal localTax() {
        if (category.equals("BOOK")) {
            return BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_UP);
        }
        return unitPrice.multiply(new BigDecimal("0.10")).setScale(2, BigDecimal.ROUND_UP); 
    }
}
