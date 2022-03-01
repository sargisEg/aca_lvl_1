package com.aca.homework.week8.credit_card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditCardTest {

    CreditCard testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CreditCard("0000 0000 0000 0000", 15000);
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("Card number: 0000 0000 0000 0000\nbalance: 15000", testSubject.toString());
    }

    @Test
    public void equalsItselfTest() {
        Assertions.assertTrue(testSubject.equals(testSubject));
    }

    @Test
    public void equalsTest() {
        CreditCard creditCard = new CreditCard("0000 0000 0000 0000", 15000);
        Assertions.assertTrue(testSubject.equals(creditCard));
    }

    @Test
    public void notEqualsTest() {
        CreditCard creditCard = new CreditCard("1234 0000 5678 0000", 15000);
        Assertions.assertFalse(testSubject.equals(creditCard));
    }
}