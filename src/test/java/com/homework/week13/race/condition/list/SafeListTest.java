package com.homework.week13.race.condition.list;

import com.aca.homework.week13.race.condition.list.List;
import com.aca.homework.week13.race.condition.list.SafeList;
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