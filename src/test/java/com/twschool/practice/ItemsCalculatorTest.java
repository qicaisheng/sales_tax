package com.twschool.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemsCalculatorTest {
    
    private ItemsTestDataFactory itemsTestDataFactory;

    @Before
    public void setUp() throws Exception {
        itemsTestDataFactory = new ItemsTestDataFactory();
    }

    @Test
    public void should_calculate_tax_given_item_value_list_and_store_is_not_in_airport() {
        ItemsCalculator itemsCalculator = new ItemsCalculator(itemsTestDataFactory.getItemValueList3(), new Store(false));
        
        String description = itemsCalculator.describe();

        Assert.assertEquals("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.82\n" +
                "Sales Taxes: 6.67\n" +
                "Total: 74.65", description);
    }
}
