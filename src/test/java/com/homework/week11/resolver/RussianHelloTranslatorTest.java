package com.homework.week11.resolver;

import com.aca.homework.week11.resolver.HelloTranslator;
import com.aca.homework.week11.resolver.LanguageType;
import com.aca.homework.week11.resolver.RussianHelloTranslator;
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