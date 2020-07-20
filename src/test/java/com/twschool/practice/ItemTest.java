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

    @Test
    public void should_calculate_tax_given_box_of_chocolates_bar_item() {
        Item item = new Item(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.LOCAL, 1, new BigDecimal("0.85"));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_packet_of_headache_pills_item() {
        Item item = new Item(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, new BigDecimal("9.75"));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_imported_bottle_of_perfume_item() {
        Item item = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, new BigDecimal("47.50"));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("2.38"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_local_bottle_of_perfume_item() {
        Item item = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, new BigDecimal("47.50"));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_get_total_price_given_imported_item() {
        Item item = new Item(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, new BigDecimal("47.50"));

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("54.63"), totalPrice);
    }

    @Test
    public void should_get_total_price_given_local_item() {
        Item item = new Item(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, new BigDecimal("14.99"));

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("16.49"), totalPrice);
    }

    @Test
    public void should_describe_given_local_item() {
        Item item = new Item(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, new BigDecimal("14.99"));

        String description = item.describe();

        Assert.assertEquals("1 music CD: 16.49", description);
    }


}
