package com.aca.homework.week13.race.condition.list;

public class NumberAdderRunnable implements Runnable {

    private final List<Integer> list;
    private final Integer number;

    public NumberAdderRunnable(List<Integer> list, Integer number) {
        this.list = list;
        this.number = number;
    }

    @Override
    public void run() {
        list.add(number);
    }
}
