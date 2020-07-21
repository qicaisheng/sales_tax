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
        List<Item> itemList;
        boolean useAirportForeignPassportTaxStrategy = store.isInAirport() && passport.isForeignPassport();
        if (useAirportForeignPassportTaxStrategy) {
            itemList = itemValueList.stream().map(itemValue -> {
                final AirportForeignPassportTaxStrategy taxStrategy = new AirportForeignPassportTaxStrategy(itemValue);
                return new Item(taxStrategy, taxStrategy.getItemValue());
            }).collect(Collectors.toList());
        } else {
            itemList = itemValueList.stream().map(itemValue -> {
                final OutsideAirportTaxStrategy taxStrategy = new OutsideAirportTaxStrategy(itemValue);
                return new Item(taxStrategy, taxStrategy.getItemValue());
            }).collect(Collectors.toList());
        }
        return describe(itemList);
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
        return itemList.stream().map(item -> item.getTaxStrategy().tax(item.getTaxStrategy().getItemValue())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
