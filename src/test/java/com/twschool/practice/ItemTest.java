package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void should_calculate_tax_given_local_book_item() {
        Item item = new Item("BOOK", "LOCAL", 1, 12.49);
        
        int tax = item.localTax();

        Assert.assertEquals(0, tax);
    }
}
