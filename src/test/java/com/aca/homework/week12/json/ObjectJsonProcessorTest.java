package com.aca.homework.week12.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObjectJsonProcessorTest {

    private ObjectJsonProcessor testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new ObjectJsonProcessor();
    }

    @Test
    public void testProcess() {
        User testUser = new User("uname1125", "Michael", "28");
        Assertions.assertEquals(
                "{\"username\": \"uname1125\", \"name\": \"Michael\", \"age\": \"28\"}",
                testSubject.process(testUser));
    }
}