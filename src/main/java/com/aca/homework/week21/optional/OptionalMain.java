package com.aca.homework.week21.optional;

import java.util.Optional;

public class OptionalMain {

    void printFirstSymbol(Optional<String> string) {

        System.out.println(string.map(s -> {
            return s.length() < 2 ? "" : s.charAt(1);
        }).orElse(""));
    }
}
