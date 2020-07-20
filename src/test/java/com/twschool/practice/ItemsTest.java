package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ItemsTest {

    @Test
    public void should_calculate_all_items_tax_1() {
        List<Item> itemList = getItemList1();
        Items items = new Items(itemList);

        Assert.assertEquals("1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83", items.describe());
    }

    @Test
    public void should_calculate_all_items_tax_2() {
        List<Item> itemList = getItemList2();
        Items items = new Items(itemList);

        Assert.assertEquals("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.63\n" +
                "Sales Taxes: 7.63\n" +
                "Total: 65.13", items.describe());
    }

    @Test
    public void should_calculate_all_items_tax_3() {
        List<Item> itemList = getItemList3();
        Items items = new Items(itemList);

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", items.describe());
    }

    private List<Item> getItemList1() {
        Item item1 = new Item(ItemCategory.BOOK, ItemFrom.LOCAL, 1, new BigDecimal("12.49"));
        Item item2 = new Item(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, new BigDecimal("14.99"));
        Item item3 = new Item(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, new BigDecimal("0.85"));
        return Arrays.asList(item1, item2, item3);
    }

    private List<Item> getItemList2() {
        Item item1 = new Item(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, new BigDecimal("10.00"));
        Item item2 = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, new BigDecimal("47.50"));
        return Arrays.asList(item1, item2);
    }

    private List<Item> getItemList3() {
        Item item1 = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, new BigDecimal("27.99"));
        Item item2 = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, new BigDecimal("18.99"));
        Item item3 = new Item(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, new BigDecimal("9.75"));
        Item item4 = new Item(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, new BigDecimal("11.25"));
        return Arrays.asList(item1, item2, item3, item4);
    }

}
