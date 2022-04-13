package com.homework.week14.shared.list;

import com.aca.homework.week14.shared.list.SharedListMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SharedListMainTest {

    @Test
    public void testStart() {
        SharedListMain testSubject = new SharedListMain();
        testSubject.start();
        Assertions.assertEquals(1000, testSubject.getListSize());
    }

}