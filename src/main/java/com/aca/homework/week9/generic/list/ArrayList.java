package com.aca.homework.week9.generic.list;

public class ArrayList<E> implements List<E> {

    private Object[] array = new Object[1000];
    private int index;

    @Override
    public void add(E object) {
        array[index] = object;
        index++;
    }

    @Override
    public E get(int index) {
        @SuppressWarnings("unchecked")
        E e = (E) array[index];
        return e;
    }

    @Override
    public int size() {
        return index;
    }
}
