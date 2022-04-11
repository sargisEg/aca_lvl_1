package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnsafeListTest {

    @Test
    public void testAddAndSize() {
        List<String> testSubject = new UnsafeList<>();
        testSubject.add("text");
        Assertions.assertEquals(1, testSubject.size());
    }
}