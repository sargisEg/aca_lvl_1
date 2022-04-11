package com.aca.homework.week8.car_repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    private CarRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CarRepository();
    }

    @Test
    public void testSave() {
        Car car = new Car("1HGBH41JXGN109186", 2016);
        testSubject.save(car);
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSaveSameCar2Times() {
        Car car = new Car("1HGBH41JXGN109186", 2016);
        testSubject.save(car);
        testSubject.save(car);
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars() {
        Car car = new Car("1HGBH41JXGN109186", 2016);
        Car car1 = new Car("1HGBH41JXAN109186", 2010);
        testSubject.save(car);
        testSubject.save(car1);
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCarsTwice() {
        Car car = new Car("1HGBH41JXGN109186", 2016);
        Car car1 = new Car("1HGBH41JXAN109186", 2010);
        testSubject.save(car);
        testSubject.save(car1);
        testSubject.save(car);
        testSubject.save(car1);
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testFindByVinWhenTotalCountIs0() {
        Assertions.assertEquals(null, testSubject.findByVin("1HGBH41JXAN109186"));
    }

    @Test
    public void testFindByVinWhenCarExists() {
        Car car = new Car("1HGBH41JXGN109186", 2016);
        testSubject.save(car);
        Assertions.assertEquals(car, testSubject.findByVin("1HGBH41JXGN109186"));
    }

    @Test
    public void testGetTotalCountWhenThereIsNoSavedCar() {
        Assertions.assertEquals(0, testSubject.getTotalCount());
    }
}