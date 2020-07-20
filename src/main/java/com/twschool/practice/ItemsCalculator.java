package com.twschool.practice;

import java.util.List;

public class ItemsCalculator {
    private final List<ItemValue> itemValueList;
    private final Store store;
    
    public ItemsCalculator(List<ItemValue> itemValueList, Store store) {
        this.itemValueList = itemValueList;
        this.store = store;
    }

    public String describe() {
        return new Items(itemValueList).describe();
    }
}
