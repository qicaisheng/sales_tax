package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class PassportTest {

    @Test
    public void should_be_foreign_passport_given_passport_with_18_numbers() {
        Passport passport = new Passport("123456789012345678");
        
        boolean isForeignPassport = passport.isForeignPassport();

        Assert.assertTrue(isForeignPassport);
    }
}
