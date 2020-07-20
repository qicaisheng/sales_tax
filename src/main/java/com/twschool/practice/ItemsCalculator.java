package com.twschool.practice;

import java.util.List;

public class ItemsCalculator {
    private final List<ItemValue> itemValueList;
    private final Store store;
    private Passport passport;

    public ItemsCalculator(List<ItemValue> itemValueList, Store store) {
        this.itemValueList = itemValueList;
        this.store = store;
    }

    public ItemsCalculator(List<ItemValue> itemValueList, Store store, Passport passport) {
        this.itemValueList = itemValueList;
        this.store = store;
        this.passport = passport;
    }

    public String describe() {
        if (store.isInAirport() && passport.isForeignPassport()) {
            return new Items(itemValueList, true).describe();
        }
        return new Items(itemValueList).describe();
    }
}
