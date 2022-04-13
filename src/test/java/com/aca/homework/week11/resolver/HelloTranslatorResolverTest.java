package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HelloTranslatorResolverTest {

    private HelloTranslatorResolver testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HelloTranslatorResolver(List.of(new EnglishHelloTranslator(), new FrenchHelloTranslator(), new RussianHelloTranslator()));
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsEnglish() {
        Assertions.assertEquals(EnglishHelloTranslator.class, testSubject.resolve(LanguageType.ENGLISH).getClass());
        Assertions.assertEquals("Hello", testSubject.resolve(LanguageType.ENGLISH).hello());
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsFrench() {
        Assertions.assertEquals(FrenchHelloTranslator.class, testSubject.resolve(LanguageType.FRENCH).getClass());
        Assertions.assertEquals("Salut", testSubject.resolve(LanguageType.FRENCH).hello());
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsRussian() {
        Assertions.assertEquals(RussianHelloTranslator.class, testSubject.resolve(LanguageType.RUSSIAN).getClass());
        Assertions.assertEquals("Привет", testSubject.resolve(LanguageType.RUSSIAN).hello());
    }



}