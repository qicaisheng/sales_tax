package com.twschool.practice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private List<Item> itemList;

    public Items(List<Item> itemList) {

        this.itemList = itemList;
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
        return itemList.stream().map(Item::tax).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
