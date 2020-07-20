package com.twschool.practice;

public class Item {
    private final String category;
    private final String from;
    private final int amount;
    private final double unitPrice;

    public Item(String category, String from, int amount, double unitPrice) {
        this.category = category;
        this.from = from;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int localTax() {
        return 0;
    }
}
