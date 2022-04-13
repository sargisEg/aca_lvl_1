package com.homework.week10.entry;

import com.aca.homework.week10.entry.Entry;
import com.aca.homework.week10.entry.EntryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EntryImplTest {

    private Entry<String, Integer> testSubject = new EntryImpl<>("key", 15);

    @Test
    public void keyTest() {
        Assertions.assertEquals("key", testSubject.key());
    }

    @Test
    public void valueTest() {
        Assertions.assertEquals(15, testSubject.value());
    }

}