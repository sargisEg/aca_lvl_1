package com.aca.homework.week11.occurence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KeyCalculatorTest {

    private KeyCalculator testSubject;

    @Test
    public void testAskAndCalculate() {
        testSubject = new KeyCalculator(new NumberSupplierForTest());
        testSubject.askAndCalculate();
        Assertions.assertEquals(7, testSubject.getValue(2));
        Assertions.assertEquals(3, testSubject.getValue(5));
    }
}