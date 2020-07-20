package com.twschool.practice;

public class Passport {
    public static final int FOREIGN_PASSPORT_NUMBER_LENGTH = 18;
    private final String number;

    public Passport(String number) {
        this.number = number;
    }

    public boolean isForeignPassport() {
        return number.length() == FOREIGN_PASSPORT_NUMBER_LENGTH;
    }
}
