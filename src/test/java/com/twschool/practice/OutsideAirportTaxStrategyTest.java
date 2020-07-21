package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OutsideAirportTaxStrategyTest {


    @Test
    public void should_calculate_tax_given_local_book_item() {
        final BigDecimal unitPrice = new BigDecimal("12.49");
        ItemValue itemValue = new ItemValue(ItemCategory.BOOK, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.localTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_music_CD_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        ItemValue itemValue = new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.localTax(itemValue);

        Assert.assertEquals(new BigDecimal("1.50"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_chocolate_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        ItemValue itemValue = new ItemValue(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.localTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_box_of_chocolates_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        ItemValue itemValue = new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.localTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_packet_of_headache_pills_item() {
        final BigDecimal unitPrice = new BigDecimal("9.75");
        ItemValue itemValue = new ItemValue(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.localTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        ItemValue itemValue = new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.importedTax(itemValue);

        Assert.assertEquals(new BigDecimal("2.38"), tax);
    }

    @Test
    public void should_calculate_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        ItemValue itemValue = new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.tax(itemValue);

        Assert.assertEquals(new BigDecimal("7.13"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_local_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        ItemValue itemValue = new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, unitPrice);
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy();

        BigDecimal tax = item.importedTax(itemValue);

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

}
