package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemCategoryTest {

    @Test
    public void should_know_BOOK_category_is_book_fond_and_medical_category() {
        ItemCategory itemCategory = ItemCategory.BOOK;

        boolean isBookFoodAndMedicalCategory = itemCategory.isBookFoodAndMedicalCategory();

        Assert.assertTrue(isBookFoodAndMedicalCategory);
    }

    @Test
    public void should_know_CHOCOLATE_BAR_category_is_book_fond_and_medical_category() {
        ItemCategory itemCategory = ItemCategory.CHOCOLATE_BAR;

        boolean isBookFoodAndMedicalCategory = itemCategory.isBookFoodAndMedicalCategory();

        Assert.assertTrue(isBookFoodAndMedicalCategory);
    }

    @Test
    public void should_know_BOX_OF_CHOCOLATE_BAR_category_is_book_fond_and_medical_category() {
        ItemCategory itemCategory = ItemCategory.BOX_OF_CHOCOLATE_BAR;

        boolean isBookFoodAndMedicalCategory = itemCategory.isBookFoodAndMedicalCategory();

        Assert.assertTrue(isBookFoodAndMedicalCategory);
    }

    @Test
    public void should_know_PACKET_OF_HEADACHE_PILLS_category_is_book_fond_and_medical_category() {
        ItemCategory itemCategory = ItemCategory.PACKET_OF_HEADACHE_PILLS;

        boolean isBookFoodAndMedicalCategory = itemCategory.isBookFoodAndMedicalCategory();

        Assert.assertTrue(isBookFoodAndMedicalCategory);
    }

    @Test
    public void should_know_MUSIC_CD_category_is_not_book_fond_and_medical_category() {
        ItemCategory itemCategory = ItemCategory.MUSIC_CD;

        boolean isBookFoodAndMedicalCategory = itemCategory.isBookFoodAndMedicalCategory();

        Assert.assertFalse(isBookFoodAndMedicalCategory);
    }
}