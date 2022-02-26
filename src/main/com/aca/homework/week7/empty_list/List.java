package com.aca.homework.week7.empty_list;

public interface List {

    int size();

    void add(Object o);

    boolean isEmpty();

    Object get(int index);

    static List ofFixedSize() {
        return new FixedSizeList();
    };

    static List ofEmpty() {
       return new List() {
           @Override
           public int size() {
               return 0;
           }

           @Override
           public void add(Object o) {
               System.err.println("List is empty");
           }

           @Override
           public boolean isEmpty() {
               return true;
           }

           @Override
           public Object get(int index) {
               System.err.println("List is empty");
               return null;
           }
       };
    }

}
