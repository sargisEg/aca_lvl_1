package com.aca.homework.week14.shared.list;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class SharedListMain {

    private final List<Integer> synchronizedList;

    public SharedListMain() {
        this.synchronizedList = new CopyOnWriteArrayList<>();
    }

    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        List<Future<?>> futureList = new LinkedList<>();

        for (int i = 0; i < 1000; i++) {
            futureList.add(
                    executorService.submit(new NumberAdderRunnable(i, synchronizedList))
            );
        }

        executorService.shutdown();

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    public int getListSize() {
        return synchronizedList.size();
    }
}
