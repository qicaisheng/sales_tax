package com.twschool.practice;

public enum ItemCategory {
    BOOK("book", "Books"), MUSIC_CD("music CD", "Audio-Visual"), CHOCOLATE_BAR("chocolate bar", "Food"), BOX_OF_CHOCOLATE_BAR("box of chocolates", "Food"), BOTTLE_OF_PERFUME("bottle of perfume", "Makeup"), PACKET_OF_HEADACHE_PILLS("packet of headache pills", "Medical");

    private String name;
    private String bigCategory;

    ItemCategory(String name, String bigCategory) {
        this.name = name;
        this.bigCategory = bigCategory;
    }

    public boolean isBookFoodAndMedicalCategory() {
        return bigCategory.equals("Books") || bigCategory.equals("Food") || bigCategory.equals("Medical");
    }

    @Override
    public String toString() {
        return name;
    }
}
