package com.aca.homework.week11.occurence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KeyCalculatorTest {

    private KeyCalculator testSubject;

    @Test
    public void testAskAndCalculate() {
        testSubject = new KeyCalculator(
                        new NumberSupplierForTest(
                        new String[]{"1", "1", "5", "2", "3", "5", "2", "2", "2", "2", "end"}
                        ));
        testSubject.askAndCalculate();
        Assertions.assertEquals(2, testSubject.getValue(1));
        Assertions.assertEquals(2, testSubject.getValue(5));
        Assertions.assertEquals(5, testSubject.getValue(2));
        Assertions.assertEquals(1, testSubject.getValue(3));
    }
}