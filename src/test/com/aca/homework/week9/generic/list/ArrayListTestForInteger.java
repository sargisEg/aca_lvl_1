package com.aca.homework.week9.generic.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTestForInteger {

    private List<Integer> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new ArrayList<>();
    }

    @Test
    public void testAddAndGet() {
        testSubject.add(Integer.valueOf(15));
        testSubject.add(Integer.valueOf(65));
        Assertions.assertEquals(Integer.valueOf(15), testSubject.get(0));
    }

    @Test
    public void testSize() {
        testSubject.add(Integer.valueOf(15));
        testSubject.add(Integer.valueOf(65));
        testSubject.add(Integer.valueOf(5));
        testSubject.add(Integer.valueOf(675));
        Assertions.assertEquals(4, testSubject.size());
    }


}