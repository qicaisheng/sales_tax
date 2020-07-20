package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    @Test
    public void should_calculate_tax_given_local_book_item() {
        Item item = new Item(ItemCategory.BOOK, ItemFrom.LOCAL, 1, new BigDecimal("12.49"));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_music_CD_item() {
        Item item = new Item(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, new BigDecimal("14.99"));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("1.50"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_chocolate_bar_item() {
        Item item = new Item(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, new BigDecimal("0.85"));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }
}
