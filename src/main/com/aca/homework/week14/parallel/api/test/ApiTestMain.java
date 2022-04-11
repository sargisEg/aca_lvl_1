package com.aca.homework.week14.parallel.api.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ApiTestMain {

    private final Map<String, String> testResultMap;

    public ApiTestMain() {
        this.testResultMap = new ConcurrentHashMap<>();
    }

    public void start() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<?>> futureList = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            futureList.add(executorService.submit(new ApiTestCallable("test description " + i, "test" + i)));
        }

        futureList.forEach(future -> {
            String result = null;
            try {
                result = future.get().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            testResultMap.put(result.split(" ")[1], result);
        });

        System.out.println(testResultMap);
    }

    public int getSize() {
        return testResultMap.size();
    }
}
