package com.aca.homework.week11.unique.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class PoolTest {

    private Pool testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Pool(new TestNameSupplier("K opel astra", "John bmw 7", "Jack opel astra", "L opel astra", "Mary bmw 7", "finish"));
    }

    @Test
    public void testAskAndCalculate() {

        Car car1 = new Car("bmw", "7");
        Car car2 = new Car("opel", "astra");
        Assertions.assertEquals(Set.of(car1, car2), testSubject.askAndCalculate());
    }
}