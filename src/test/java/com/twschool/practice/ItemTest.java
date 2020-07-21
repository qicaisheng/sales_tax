package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ItemTest {

    @Test
    public void should_get_total_price_given_imported_item() {
        final BigDecimal unitPrice = new BigDecimal("47.50");
        ItemValue itemValue = new ItemValue(ItemCategory.BOTTLE_OF_PERFUME, ItemFrom.IMPORTED, 1, unitPrice);
        final OutsideAirportTaxStrategy taxStrategy = new OutsideAirportTaxStrategy(itemValue);
        Item item = new Item(taxStrategy, itemValue);

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("54.63"), totalPrice);
    }

    @Test
    public void should_get_total_price_given_local_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        ItemValue itemValue = new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice);
        final OutsideAirportTaxStrategy taxStrategy = new OutsideAirportTaxStrategy(itemValue);
        Item item = new Item(taxStrategy, itemValue);

        BigDecimal totalPrice = item.totalPrice();

        Assert.assertEquals(new BigDecimal("16.49"), totalPrice);
    }

    @Test
    public void should_describe_given_local_item() {
        final BigDecimal unitPrice = new BigDecimal("14.99");
        ItemValue itemValue = new ItemValue(ItemCategory.MUSIC_CD, ItemFrom.LOCAL, 1, unitPrice);
        final OutsideAirportTaxStrategy taxStrategy = new OutsideAirportTaxStrategy(itemValue);
        Item item = new Item(taxStrategy, itemValue);

        String description = item.describe();

        Assert.assertEquals("1 music CD: 16.49", description);
    }

    @Test
    public void should_describe_given_imported_item() {
        final BigDecimal unitPrice = new BigDecimal("10.00");
        ItemValue itemValue = new ItemValue(ItemCategory.BOX_OF_CHOCOLATE_BAR, ItemFrom.IMPORTED, 1, unitPrice);
        final OutsideAirportTaxStrategy taxStrategy = new OutsideAirportTaxStrategy(itemValue);
        Item item = new Item(taxStrategy, itemValue);

        String description = item.describe();

        Assert.assertEquals("1 imported box of chocolates: 10.50", description);
    }
}
