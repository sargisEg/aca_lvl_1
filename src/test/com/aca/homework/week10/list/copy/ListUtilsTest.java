package com.aca.homework.week10.list.copy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListUtilsTest {

    @Test
    public void testCopy() {
        List<String> testList = List.of("a", "b", "c");
        List<String> copyList = ListUtils.copy(testList);
        Assertions.assertFalse(testList == copyList);
        Assertions.assertEquals(testList.get(0), copyList.get(0));
        Assertions.assertEquals(testList.get(1), copyList.get(1));
        Assertions.assertEquals(testList.get(2), copyList.get(2));
    }
}