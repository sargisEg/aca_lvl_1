package com.aca.homework.week6.list;

import java.util.Arrays;

public class ArrayList implements List{
    private int size = 10;
    private String[] myArrayList = new String[size];
    private int iterator = 0;

    @Override
    public void add(String element) {
        if (iterator == size){
            addCapacity();
        }
        myArrayList[iterator] = element;
        iterator++;
    }

    @Override
    public String get(int index) {
        if(index < 0 || index >= size){
            throw new RuntimeException();
        }else {
            return myArrayList[index];
        }
    }

    private void addCapacity(){
        myArrayList = Arrays.copyOf(myArrayList, size*2);
    }
}
