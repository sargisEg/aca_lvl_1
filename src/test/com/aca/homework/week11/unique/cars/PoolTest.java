package com.aca.homework.week11.unique.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PoolTest {

    private Pool testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Pool(new TestNameInput("K opel astra", "John bmw 7", "Jack opel astra", "L opel astra", "Mary bmw 7", "finish"));
    }

    @Test
    public void testAskAndCalculate() {
        Assertions.assertEquals(Set.of("bmw 7", "opel astra"), testSubject.askAndCalculate());
    }
}