package com.aca.homework.week10.concrete.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private Map testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Map();
    }

    @Test
    public void testPutWhenKeyIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.put(null, "Value");
            }
        });
    }

    @Test
    public void testPutWhenValueIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.put("Key", null);
            }
        });
    }

    @Test
    public void testGetValueWhenValueIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getValue(null);
            }
        });
    }

    @Test
    public void testGetValueWhenKeyIsNotFound() {
        testSubject.put("key1", "value1");
        Assertions.assertEquals(null, testSubject.getValue("testKey"));
    }

    @Test
    public void testGetValueWhenKeyIsFound() {
        testSubject.put("key1", "value1");
        testSubject.put("Java Help Centre Phone Number", "+3743743743");
        Assertions.assertEquals("value1", testSubject.getValue("key1"));
        Assertions.assertEquals("+3743743743", testSubject.getValue("Java Help Centre Phone Number"));
    }

    @Test
    public void testSizeWhenEmpty() {
        Assertions.assertEquals(0, testSubject.size());
    }

    @Test
    public void testSizeWhen1PairIsAdded() {
        testSubject.put("Java Help Centre Phone Number", "+3743743743");
        Assertions.assertEquals(1, testSubject.size());
    }

}