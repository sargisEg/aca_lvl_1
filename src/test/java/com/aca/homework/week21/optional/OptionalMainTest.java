package com.aca.homework.week21.optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalMainTest {

    private OptionalMain optionalMain;

    @BeforeEach
    public void init() {
        optionalMain = new OptionalMain();
    }

    @Test
    public void testWhenOptionalIsEmpty() {
        optionalMain.printFirstSymbol(Optional.empty());
    }

    @Test
    public void testWhenStringIsEmpty() {
        optionalMain.printFirstSymbol(Optional.of(""));
    }

    @Test
    public void testWhenStringHas1Symbol() {
        optionalMain.printFirstSymbol(Optional.of("a"));
    }

    @Test
    public void testWhenStringHas2Symbols() {
        optionalMain.printFirstSymbol(Optional.of("ab"));
    }

}