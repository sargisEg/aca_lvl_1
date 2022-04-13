package com.aca.homework.week8.car_repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testWhenReferenceIsSame() {
        Car car = new Car("1HGBH41JXDN109186", 2013);
        Assertions.assertEquals(true, car.equals(car));
    }

    @Test
    public void testWhenCarsHaveSameFieldValues() {
        Car car = new Car("1HGBH41JXDN109186", 2013);
        Car car1 = new Car("1HGBH41JXDN109186", 2013);
        Assertions.assertEquals(true, car.equals(car1));
    }

    @Test
    public void testCarEqualString() {
        Car car = new Car("1HGBH41JXDN109186", 2013);
        Assertions.assertFalse(car.equals("string"));
    }


}