package com.twschool.practice;

public enum ItemCategory {
    BOOK("Books"), MUSIC_CD("Audio-Visual"), CHOCOLATE_BAR("Food"), BOX_OF_CHOCOLATE_BAR("Food"), BOTTLE_OF_PERFUME("Makeup"), PACKET_OF_HEADACHE_PILLS("Medical");

    private String bigCategory;

    ItemCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }

    public boolean isBookFoodAndMedicalCategory() {
        return bigCategory.equals("Books") || bigCategory.equals("Food") || bigCategory.equals("Medical");
    }
}
