package com.aca.homework.week8.random_generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowPerformanceRandomStringGeneratorTest {

    private RandomStringGenerator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HighPerformanceRandomStringGenerator();
    }

    @Test
    public void testWrongNumber() {
        Assertions.assertEquals("error", testSubject.randomString(5).getText());
        Assertions.assertEquals(0, testSubject.randomString(5).getDuration());
    }

    @Test
    public void test30000() {
        Assertions.assertEquals(30_000, testSubject.randomString(30_000).getText().length());
        Assertions.assertTrue(testSubject.randomString(30_000).getDuration() > 0);
    }


}