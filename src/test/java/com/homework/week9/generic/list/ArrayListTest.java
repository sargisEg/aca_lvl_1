package com.homework.week9.generic.list;

import com.aca.homework.week9.generic.list.ArrayList;
import com.aca.homework.week9.generic.list.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayListTest {

    @Test
    public void testAddAndGetForInteger() {
        List<Integer> testSubject = new ArrayList<>();
        testSubject.add(Integer.valueOf(15));
        testSubject.add(Integer.valueOf(65));
        Assertions.assertEquals(Integer.valueOf(15), testSubject.get(0));
    }

    @Test
    public void testSizeForInteger() {
        List<Integer> testSubject = new ArrayList<>();
        testSubject.add(Integer.valueOf(15));
        testSubject.add(Integer.valueOf(65));
        testSubject.add(Integer.valueOf(5));
        testSubject.add(Integer.valueOf(675));
        Assertions.assertEquals(4, testSubject.size());
    }

    @Test
    public void testAddAndGetForString() {
        List<String> testSubject = new ArrayList<>();
        testSubject.add("text1");
        testSubject.add("text2");
        Assertions.assertEquals("text1", testSubject.get(0));
    }

    @Test
    public void testSizeForString() {
        List<String> testSubject = new ArrayList<>();
        testSubject.add("text1");
        testSubject.add("text2");
        testSubject.add("text3");
        testSubject.add("text4");
        Assertions.assertEquals(4, testSubject.size());
    }
}