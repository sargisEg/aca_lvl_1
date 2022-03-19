package com.aca.homework.week11.map.performance;

import java.util.Random;

public class Randomizer {

    private char[] elements = {'a', 'b', 'c', 'd', 'e'};

    public String get8SizedString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            builder.append(getRandomElement());
        }

        return builder.toString();
    }

    private char getRandomElement() {
        return elements[new Random().nextInt(4)];
    }
}
