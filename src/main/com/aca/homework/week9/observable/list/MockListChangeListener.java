package com.aca.homework.week9.observable.list;

public class MockListChangeListener<T> implements ListChangeListener<T> {

    private int methodCount;

    @Override
    public void onAdded(T item) {
        methodCount++;
        System.out.println("onAdded method: " + item);
    }

    public int getMethodCount() {
        return methodCount;
    }
}
