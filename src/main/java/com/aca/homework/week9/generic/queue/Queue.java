package com.aca.homework.week9.generic.queue;

public class Queue<T> {

    private Object[] array = new Object[10_000];
    private int pointer = 0;

    public void produce(T object) {
        if(object == null)
            throw new IllegalArgumentException("Object is null");
        array[pointer] = object;
        pointer++;
    }

    public T consume() {
        if (pointer == 0)
            throw new QueueEmptyException("Queue is empty");
        T lastObject = (T) array[pointer - 1];
        array[pointer - 1] = null;
        pointer--;
        return lastObject;
    }

}
