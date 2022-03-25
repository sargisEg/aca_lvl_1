package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RussianHelloTranslatorTest {

    private HelloTranslator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new RussianHelloTranslator();
    }

    @Test
    public void testHello() {
        Assertions.assertEquals("Привет", testSubject.hello());
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.RUSSIAN, testSubject.type());
    }
}