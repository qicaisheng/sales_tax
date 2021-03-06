package com.twschool.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ItemsCalculatorTest {
    
    private ItemsTestDataFactory itemsTestDataFactory;

    @Before
    public void setUp() throws Exception {
        itemsTestDataFactory = new ItemsTestDataFactory();
    }

    @Test
    public void should_calculate_tax_given_item_value_list_and_store_is_not_in_airport() {
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemsTestDataFactory.getItemValueList3(), new Store(false), new Passport("123456789012345678"));
        
        String description = itemsCalculator.describe();

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", description);
    }

    @Test
    public void should_calculate_tax_given_item_value_list_and_store_is_in_airport_and_foreign_passport() {
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemsTestDataFactory.getItemValueList3(), new Store(true), new Passport("123456789012345678"));

        String description = itemsCalculator.describe();

        Assert.assertEquals("1 imported bottle of perfume: 30.79\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 10.73\n" +
                "1 imported box of chocolates: 12.38\n" +
                "Sales Taxes: 6.81\n" +
                "Total: 74.79", description);
    }

    @Test
    public void should_calculate_tax_given_item_value_list_and_store_is_in_airport_and_local_passport() {
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemsTestDataFactory.getItemValueList3(), new Store(true), new Passport("123456789012345"));

        String description = itemsCalculator.describe();

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", description);
    }


    @Test
    public void should_calculate_all_items_tax_1() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList1();
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemList, new Store(false), new Passport("123456789012345678"));

        Assert.assertEquals("1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83", itemsCalculator.describe());
    }

    @Test
    public void should_calculate_all_items_tax_2() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList2();
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemList, new Store(false), new Passport("123456789012345678"));

        Assert.assertEquals("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.63\n" +
                "Sales Taxes: 7.63\n" +
                "Total: 65.13", itemsCalculator.describe());
    }

    @Test
    public void should_calculate_all_items_tax_3() {
        List<ItemValue> itemList = itemsTestDataFactory.getItemValueList3();
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemList, new Store(false), new Passport("123456789012345678"));

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", itemsCalculator.describe());
    }

}
