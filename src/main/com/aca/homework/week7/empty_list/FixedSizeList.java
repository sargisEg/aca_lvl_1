package com.aca.homework.week7.empty_list;

public class FixedSizeList implements List {

    private Object[] array = new Object[10];
    private int index = 0;

    @Override
    public int size() {
        return index;
    }

    @Override
    public void add(Object o) {
        if(index == 10) {
            System.err.println("The list is full");
        }else {
            array[index] = o;
            index++;
        }
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public Object get(int index) {
        if (index < this.index && index >= 0)
            return array[index];
        return null;
    }
}
