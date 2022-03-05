package com.aca.homework.week9.tuple2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tuple2Test {

    @Test
    public void tupl2StringAndIntegerTest() {
        Tuple2<String, Integer> testSubject = new Tuple2<>("text", 45);
        Assertions.assertEquals("text",testSubject.getT1());
        Assertions.assertEquals(45,testSubject.getT2());
    }

    @Test
    public void tupl2LongAndIntegerTest() {
        Tuple2<Long, Integer> testSubject = new Tuple2<>(100L, 45);
        Assertions.assertEquals(100L,testSubject.getT1());
        Assertions.assertEquals(45,testSubject.getT2());
    }
}