package com.aca.homework.week8.random_generator;

public class HighPerformanceRandomStringGenerator implements RandomStringGenerator{

    @Override
    public Result randomString(int length) {
        if (length % 3 != 0) {
            return Result.of("error", 0);
        }
        long startMillis = System.currentTimeMillis();

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length / 3; i++) {
            text.append(Randomizer.randomString());
        }
        return Result.of(text.toString(), System.currentTimeMillis() - startMillis);
    }
}
