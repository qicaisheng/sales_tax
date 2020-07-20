package com.twschool.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    
    private ItemsTestDataFactory itemsTestDataFactory;

    @Before
    public void setUp() throws Exception {
        itemsTestDataFactory = new ItemsTestDataFactory();
    }

    @Test
    public void should_calculate_all_items_tax_1() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList1();
        Items items = new Items(itemList);

        Assert.assertEquals("1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83", items.describe());
    }

    @Test
    public void should_calculate_all_items_tax_2() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList2();
        Items items = new Items(itemList);

        Assert.assertEquals("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.63\n" +
                "Sales Taxes: 7.63\n" +
                "Total: 65.13", items.describe());
    }

    @Test
    public void should_calculate_all_items_tax_3() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList3();
        Items items = new Items(itemList);

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", items.describe());
    }


}
