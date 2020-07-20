package com.twschool.practice;

public class Passport {
    private String number;

    public Passport(String number) {
        this.number = number;
    }

    public boolean isForeignPassport() {
        return number.length() == 18;
    }
}
