package com.homework.week11.resolver;

import com.aca.homework.week11.resolver.EnglishHelloTranslator;
import com.aca.homework.week11.resolver.HelloTranslator;
import com.aca.homework.week11.resolver.LanguageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnglishHelloTranslatorTest {

    private HelloTranslator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new EnglishHelloTranslator();
    }

    @Test
    public void testHello() {
        Assertions.assertEquals("Hello", testSubject.hello());
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.ENGLISH, testSubject.type());
    }

}