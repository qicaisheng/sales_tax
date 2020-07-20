package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    @Test
    public void should_calculate_tax_given_local_book_item() {
        final BigDecimal unitPrice = new BigDecimal("12.49");
        Item item = new Item(new ItemValue(ItemCategory.BOOK, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_music_CD_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        Item item = new Item(new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("1.50"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_chocolate_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        Item item = new Item(new ItemValue(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_box_of_chocolates_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        Item item = new Item(new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_packet_of_headache_pills_item() {
        final BigDecimal unitPrice = new BigDecimal("9.75");
        Item item = new Item(new ItemValue(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        Item item = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("2.38"), tax);
    }

    @Test
    public void should_calculate_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        Item item = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice));

        BigDecimal tax = item.tax();

        Assert.assertEquals(new BigDecimal("7.13"), tax);
    }
    
    @Test
    public void should_calculate_imported_tax_given_local_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        Item item = new Item(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_get_total_price_given_imported_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        ItemValue itemValue = new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice);
        Item item = new Item(itemValue, new OutsideAirportTaxStrategy(itemValue));

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("54.63"), totalPrice);
    }

    @Test
    public void should_get_total_price_given_local_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        ItemValue itemValue = new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice);
        Item item = new Item(itemValue, new OutsideAirportTaxStrategy(itemValue));

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("16.49"), totalPrice);
    }

    @Test
    public void should_describe_given_local_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        ItemValue itemValue = new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice);
        Item item = new Item(itemValue, new OutsideAirportTaxStrategy(itemValue));

        String description = item.describe();

        Assert.assertEquals("1 music CD: 16.49", description);
    }

    @Test
    public void should_describe_given_imported_item() {
        final BigDecimal unitPrice = new BigDecimal("10.00");
        ItemValue itemValue = new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, unitPrice);
        Item item = new Item(itemValue, new OutsideAirportTaxStrategy(itemValue));

        String description = item.describe();

        Assert.assertEquals("1 imported box of chocolates: 10.50", description);
    }
}
