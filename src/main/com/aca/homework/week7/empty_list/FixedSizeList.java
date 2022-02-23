package com.aca.homework.week7.empty_list;

public class FixedSizeList implements List {

    Object[] array = new Object[10];
    int iterator = 0;

    @Override
    public int size() {
        return 10;
    }

    @Override
    public void add(Object o) {
        if(iterator == 10) {
            System.err.println("The list is full");
        }else {
            array[iterator] = o;
            iterator++;
        }
    }

    @Override
    public boolean isEmpty() {
        return array[0] == null;
    }

    @Override
    public Object get(int index) {
        if (index < iterator && index >= 0)
            return array[index];
        return null;
    }
}
