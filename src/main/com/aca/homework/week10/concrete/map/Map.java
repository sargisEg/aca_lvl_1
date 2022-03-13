package com.aca.homework.week10.concrete.map;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Entry> entries = new ArrayList<>();

    public void put(@NotNull String key, @NotNull String value) {
        if (key == null)
            throw new IllegalArgumentException("The Key is null");
        if (value == null)
            throw new IllegalArgumentException("The Value is null");
        Entry entry = Entry.of(key, value);
        if (getValue(key) == null) {
            entries.add(entry);
        } else {
            entries.set(entries.indexOf(getIndexByKey(key)), entry);
        }
    }

    private Entry getIndexByKey(String key) {
        for (Entry entry : entries) {
            if (entry.key().equals(key))
                return entry;
        }
        return null;
    }

    public String getValue(@NotNull String key) {
        if (key == null)
            throw new IllegalArgumentException("Value is null");
        for (Entry entry : entries) {
            if (entry.key().equals(key))
                return entry.value();
        }
        return null;
    }

    public int size() {
        return entries.size();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

}
