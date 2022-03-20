package com.aca.homework.week11.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingerTest {

    @Test
    public void testHashCodeIfEquals() {
        Singer testSinger1 = new Singer("first", "last");
        Singer testSinger2 = new Singer("first", "last");

        Assertions.assertEquals(testSinger1, testSinger2);
        Assertions.assertEquals(testSinger1.hashCode(), testSinger2.hashCode());

    }

}