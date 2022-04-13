package com.homework.week13.race.condition.list;

import com.aca.homework.week13.race.condition.list.List;
import com.aca.homework.week13.race.condition.list.UnsafeList;
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