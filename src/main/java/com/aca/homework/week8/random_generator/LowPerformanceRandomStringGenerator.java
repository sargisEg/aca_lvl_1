package com.aca.homework.week8.random_generator;

public class LowPerformanceRandomStringGenerator implements RandomStringGenerator {
    @Override
    public Result randomString(int length) {
        if (length % 3 != 0) {
            return Result.of("error", 0);
        }
        long startMillis = System.currentTimeMillis();

        String text = "";
        for (int i = 0; i < length / 3; i++) {
            text += Randomizer.randomString();
        }
        return Result.of(text, System.currentTimeMillis() - startMillis);

    }
}
