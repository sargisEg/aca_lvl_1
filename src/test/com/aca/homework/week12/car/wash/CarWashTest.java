package com.aca.homework.week12.car.wash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarWashTest {

    CarWash testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CarWash("JILLY'S", new TestCarRepository());
    }

    @Test
    public void testWash1Time() {
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
    }

    @Test
    public void testWash5Times() {
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(0, testSubject.wash("11AA111"));
    }

    @Test
    public void testWash6Times() {
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(0, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));

    }

    @Test
    public void testWash10Times() {
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(0, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(3.5, testSubject.wash("11AA111"));
        Assertions.assertEquals(0, testSubject.wash("11AA111"));

    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("JILLY'S", testSubject.getName());
    }
}