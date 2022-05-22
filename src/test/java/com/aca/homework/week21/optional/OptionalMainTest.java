package com.aca.homework.week21.optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class OptionalMainTest {

    @Test
    public void testWhenOptionalIsEmpty() {
        final int[] count = {0};
        OptionalMain optionalMain = new OptionalMain(s -> {
            System.out.println(s);
            count[0]++;
        });

        optionalMain.printFirstSymbol(Optional.empty());

        Assertions.assertThat(0).isEqualTo(count[0]);
    }

    @Test
    public void testWhenStringIsEmpty() {
        final int[] count = {0};
        OptionalMain optionalMain = new OptionalMain(s -> {
            System.out.println(s);
            count[0]++;
        });

        optionalMain.printFirstSymbol(Optional.of(""));

        Assertions.assertThat(0).isEqualTo(count[0]);
    }

    @Test
    public void testWhenStringHas1Symbol() {
        final int[] count = {0};
        OptionalMain optionalMain = new OptionalMain(s -> {
            System.out.println(s);
            count[0]++;
        });

        optionalMain.printFirstSymbol(Optional.of("a"));

        Assertions.assertThat(0).isEqualTo(count[0]);
    }

    @Test
    public void testWhenStringHas2Symbols() {
        final int[] count = {0};
        OptionalMain optionalMain = new OptionalMain(s -> {
            System.out.println(s);
            count[0]++;
        });

        optionalMain.printFirstSymbol(Optional.of("ab"));

        Assertions.assertThat(1).isEqualTo(count[0]);
    }

}