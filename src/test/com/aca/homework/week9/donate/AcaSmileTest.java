package com.aca.homework.week9.donate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcaSmileTest {

    private AcaSmile testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new AcaSmile();
    }

    @Test
    public void testWhenNothingIsBought() {
        Assertions.assertEquals(0, testSubject.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneIsBought() {
        testSubject.buyWithDonation(new Smartphone(100));
        Assertions.assertEquals(5, testSubject.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneAndOneWatchIsBought() {
        testSubject.buyWithDonation(new Smartphone(100));
        testSubject.buyWithDonation(new Watch(200));
        Assertions.assertEquals(15, testSubject.getTotalDonatedAmount());
    }

    @Test
    public void testWhenOneSmartphoneOneWatchAndOneSmartWatchIsBought() {
        testSubject.buyWithDonation(new Smartphone(100));
        testSubject.buyWithDonation(new Watch(200));
        testSubject.buyWithDonation(new SmartWatch(1000));
        Assertions.assertEquals(65, testSubject.getTotalDonatedAmount());
    }

    @Test
    public void testOfPurchasedGoodsList() {
        testSubject.buyWithDonation(new Smartphone(100));
        testSubject.buyWithDonation(new Watch(200));
        testSubject.buyWithDonation(new Watch(150));
        Assertions.assertEquals("Smartphone", testSubject.getDonatedGoods().get(0));
        Assertions.assertEquals("Watch", testSubject.getDonatedGoods().get(1));
        Assertions.assertEquals("Watch", testSubject.getDonatedGoods().get(2));
    }
}