package com.twschool.practice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private List<Item> itemList;
    
    public Items(List<ItemValue> itemValueList) {
        this.itemList = itemValueList.stream().map(itemValue -> new Item(new OutsideAirportTaxStrategy(itemValue))).collect(Collectors.toList());
    }

    public String describe() {
        String itemsDescription = itemList.stream().map(Item::describe).collect(Collectors.joining("\n"));
        String taxesDescription = "\nSales Taxes: " + totalTaxes().toString();
        String totalDescription = "\nTotal: " + totalPrices().toString();
        return itemsDescription + taxesDescription + totalDescription;
    }

    private BigDecimal totalPrices() {
        return itemList.stream().map(Item::totalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal totalTaxes() {
        return itemList.stream().map(item -> item.getTaxStrategy().tax()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
