package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SafeListTest {

    @Test
    public void testAddAndSize() {
        List<String> testSubject = new SafeList<>();
        testSubject.add("text");
        Assertions.assertEquals(1, testSubject.size());
    }
}