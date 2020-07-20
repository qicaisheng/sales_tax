package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OutsideAirportTaxStrategyTest {


    @Test
    public void should_calculate_tax_given_local_book_item() {
        final BigDecimal unitPrice = new BigDecimal("12.49");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.BOOK, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_music_CD_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("1.50"), tax);
    }

    @Test
    public void should_calculate_tax_given_local_chocolate_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_box_of_chocolates_bar_item() {
        final BigDecimal unitPrice = new BigDecimal("0.85");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_tax_given_packet_of_headache_pills_item() {
        final BigDecimal unitPrice = new BigDecimal("9.75");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.PACKET_OF_HEADACHE_PILLS, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.localTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("2.38"), tax);
    }

    @Test
    public void should_calculate_tax_given_imported_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice));

        BigDecimal tax = item.tax();

        Assert.assertEquals(new BigDecimal("7.13"), tax);
    }

    @Test
    public void should_calculate_imported_tax_given_local_bottle_of_perfume_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        OutsideAirportTaxStrategy item = new OutsideAirportTaxStrategy(new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.LOCAL, 1, unitPrice));

        BigDecimal tax = item.importedTax();

        Assert.assertEquals(new BigDecimal("0.00"), tax);
    }

}
