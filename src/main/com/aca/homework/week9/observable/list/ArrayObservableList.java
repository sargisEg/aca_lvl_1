package com.aca.homework.week9.observable.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayObservableList<T> implements ObservableList<T>{

    private Object[] array = new Object[10_000];
    private int index = 0;
    private List<ListChangeListener<T>> listenersList = new ArrayList<>();

    @Override
    public void add(T object) {
        array[index] = object;
        if (!listenersList.isEmpty()) {
            for (ListChangeListener<T> listChangeListener : listenersList) {
                listChangeListener.onAdded(object);
            }
        }
        index++;
    }

    @Override
    public T get(int index) {
        @SuppressWarnings("unchecked")
        T t = (T) array[index];
        return t;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void addListener(ListChangeListener<T> listener) {
        listenersList.add(listener);
    }
}
