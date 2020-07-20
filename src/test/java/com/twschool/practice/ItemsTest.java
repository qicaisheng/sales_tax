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

    private List<Item> getItemList1() {
        Item item1 = new Item(ItemCategory.BOOK, ItemFrom.LOCAL, 1, new BigDecimal("12.49"));
        Item item2 = new Item(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, new BigDecimal("14.99"));
        Item item3 = new Item(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, new BigDecimal("0.85"));
        return Arrays.asList(item1, item2, item3);
    }


}
