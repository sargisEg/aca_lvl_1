package com.aca.homework.week21.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalMain {

    private final Consumer<Character> consumer;

    public OptionalMain(Consumer<Character> consumer) {
        this.consumer = consumer;
    }

    void printFirstSymbol(Optional<String> string) {

        string.ifPresent(s -> {
            if (s.length() >= 2) {
                consumer.accept(s.charAt(1));
            }
        });

    }

}
