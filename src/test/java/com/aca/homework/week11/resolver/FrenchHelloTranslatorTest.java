package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrenchHelloTranslatorTest {

    private HelloTranslator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new FrenchHelloTranslator();
    }

    @Test
    public void testHello() {
        Assertions.assertEquals("Salut", testSubject.hello());
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.FRENCH, testSubject.type());
    }

}