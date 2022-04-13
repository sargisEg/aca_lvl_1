package com.aca.homework.week14.shared.list;

import java.util.List;

public class NumberAdderRunnable implements Runnable {

    private final int number;
    private final List<Integer> sharedList;

    public NumberAdderRunnable(int number, List<Integer> sharedList) {
        this.number = number;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        sharedList.add(number);
    }
}
