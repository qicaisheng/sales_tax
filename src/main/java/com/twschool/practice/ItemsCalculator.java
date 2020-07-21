package com.twschool.practice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsCalculator {
    private final List<ItemValue> itemValueList;
    private final Store store;
    private final Passport passport;

    public ItemsCalculator(List<ItemValue> itemValueList, Store store, Passport passport) {
        this.itemValueList = itemValueList;
        this.store = store;
        this.passport = passport;
    }

    public String describe() {
        boolean useAirportForeignPassportTaxStrategy = store.isInAirport() && passport.isForeignPassport();
        TaxStrategy taxStrategy1;
        if (useAirportForeignPassportTaxStrategy) {
            taxStrategy1 = new AirportForeignPassportTaxStrategy();
        } else {
            taxStrategy1 = new OutsideAirportTaxStrategy();
        }
        List<Item> itemList1 = itemValueList.stream().map(itemValue -> new Item(taxStrategy1, itemValue)).collect(Collectors.toList());
        return describe(itemList1);
    }
    
    public String describe(List<Item> itemList) {
        String itemsDescription = itemList.stream().map(Item::describe).collect(Collectors.joining("\n"));
        String taxesDescription = "\nSales Taxes: " + totalTaxes(itemList).toString();
        String totalDescription = "\nTotal: " + totalPrices(itemList).toString();
        return itemsDescription + taxesDescription + totalDescription;
    }

    private BigDecimal totalPrices(List<Item> itemList) {
        return itemList.stream().map(Item::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal totalTaxes(List<Item> itemList) {
        return itemList.stream().map(item -> item.getTaxStrategy().tax(item.getItemValue())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
