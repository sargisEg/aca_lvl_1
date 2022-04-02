package com.aca.homework.week13.race.condition.list;

import java.util.function.Supplier;

public class RaceConditionGenerator {

    private final Thread[] threads = new Thread[10_000];
    private List<Integer> raceList;

    public RaceConditionGenerator(Supplier<Boolean> supplier) {
        initializeList(supplier);
        initializeThreads();
    }

    private void initializeList(Supplier<Boolean> supplier) {
        boolean listType = supplier.get();
        if (listType) {
            raceList = new SafeList<>();
        } else {
            raceList = new UnsafeList<>();
        }
    }

    private void initializeThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NumberAdderRunnable(raceList, i));
        }
    }

    public int start() {
        startThreads();
        joinThreads();
        return raceList.size();
    }

    private void joinThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
