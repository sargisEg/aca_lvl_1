package com.aca.homework.week14.parallel.api.test;

import java.util.Random;
import java.util.concurrent.Callable;

public class ApiTestCallable implements Callable<String> {

    private final String testDescription;
    private final String testName;

    public ApiTestCallable(String testDescription, String testName) {
        this.testDescription = testDescription;
        this.testName = testName;
    }

    @Override
    public String call() throws Exception {
        String result;
        Thread.sleep(2000);
        if (new Random().nextInt(2) == 0) {
            result = "Passed";
        } else {
            result = "Failed";
        }

        return result + " " + testName + " " + testDescription;
    }
}