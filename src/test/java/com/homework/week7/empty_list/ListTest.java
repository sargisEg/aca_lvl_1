package com.homework.week7.empty_list;

import com.aca.homework.week7.empty_list.List;

class ListTest {
    public static void main(String[] args) {
        List emptyList = List.ofEmpty();
        List fixedList = List.ofFixedSize();

        System.out.println(emptyList.isEmpty());
        System.out.println(emptyList.size());
        emptyList.add(new Object());
        emptyList.get(0);

        System.out.println(fixedList.isEmpty());
        System.out.println(fixedList.size());
        fixedList.get(5);
        fixedList.add(new Object());
        fixedList.add(new Object());
        fixedList.get(0);
        fixedList.get(2);

    }
}