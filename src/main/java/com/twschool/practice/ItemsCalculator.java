package com.twschool.practice;

import java.util.List;

public class ItemsCalculator {
    private final List<Item> itemList;
    private final Store store;

    public ItemsCalculator(List<Item> itemList, Store store) {
        this.itemList = itemList;
        this.store = store;
    }

    public String describe() {
        return new Items(itemList).describe();
    }
}
