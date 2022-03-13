package com.aca.homework.week10.concrete.map;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<String> values = new ArrayList<>();
    private List<String> keys = new ArrayList<>();
    private int size = 0;

    public void put(@NotNull String key, @NotNull String value) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
        if (value == null)
            throw new IllegalArgumentException("Value is null");
        values.add(value);
        keys.add(key);
        size++;
    }

    public String getValue(@NotNull String key) {
        if (key == null)
            throw new IllegalArgumentException("Value is null");
        int index = keys.indexOf(key);
        if(index != -1)
            return values.get(index);
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
