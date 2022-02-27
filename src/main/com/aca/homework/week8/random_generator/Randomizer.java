package com.aca.homework.week8.random_generator;

import java.util.Random;

public class Randomizer {

    private static char[] charactersForString = {'a', 'b', '7', '1', '9', '-'};

    public static String randomString() {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            randomString.append(getRandomCharacter());
        }
        return randomString.toString();
    }

    private static char getRandomCharacter() {
        return charactersForString[new Random().nextInt(charactersForString.length)];
    }
}
