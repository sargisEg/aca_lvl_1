package com.aca.homework.week9.generic.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTestForString {

    private List<String> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new ArrayList<>();
    }

    @Test
    public void testAddAndGet() {
        testSubject.add("text1");
        testSubject.add("text2");
        Assertions.assertEquals("text1", testSubject.get(0));
    }

    @Test
    public void testSize() {
        testSubject.add("text1");
        testSubject.add("text2");
        testSubject.add("text3");
        testSubject.add("text4");
        Assertions.assertEquals(4, testSubject.size());
    }

}