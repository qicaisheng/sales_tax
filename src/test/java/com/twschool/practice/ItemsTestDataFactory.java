package com.twschool.practice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemsTestDataFactory {

    public List<Item> getItemList1() {
        final BigDecimal unitPrice = new BigDecimal("12.49");
        Item item1 = new Item(new ItemValue(ItemCategory.BOOK, ItemFrom.LOCAL, 1, unitPrice));
        final BigDecimal unitPrice1 = new BigDecimal("14.99");
        Item item2 = new Item(new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice1));
        final BigDecimal unitPrice2 = new BigDecimal("0.85");
        Item item3 = new Item(new ItemValue(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice2));
        return Arrays.asList(item1, item2, item3);
    }

    public List<Item> getItemList2() {
        final BigDecimal unitPrice = new BigDecimal("10.00");
        Item item1 = new Item(new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, unitPrice));
        final BigDecimal unitPrice1 = new BigDecimal("47.50");
        Item item2 = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice1));
        return Arrays.asList(item1, item2);
    }

    public List<Item> getItemList3() {
        final BigDecimal unitPrice = new BigDecimal("27.99");
        Item item1 = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice));
        final BigDecimal unitPrice1 = new BigDecimal("18.99");
        Item item2 = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, unitPrice1));
        final BigDecimal unitPrice2 = new BigDecimal("9.75");
        Item item3 = new Item(new ItemValue(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, unitPrice2));
        final BigDecimal unitPrice3 = new BigDecimal("11.25");
        Item item4 = new Item(new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, unitPrice3));
        return Arrays.asList(item1, item2, item3, item4);
    }

}
