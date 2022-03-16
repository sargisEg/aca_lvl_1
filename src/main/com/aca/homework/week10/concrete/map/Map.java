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
        Entry newEntry = Entry.of(key, value);
        Entry myEntry = getEntryByKey(key);
        if (myEntry != null) {
            entries.set(entries.indexOf(myEntry), newEntry);
        } else {
            entries.add(newEntry);
        }
    }

    private Entry getEntryByKey(String key) {
        for (Entry entry : entries) {
            if (entry.key().equals(key))
                return entry;
        }
        return null;
    }

    public String getValue(@NotNull String key) {
        if (key == null)
            throw new IllegalArgumentException("Value is null");
        Entry entryByKey = getEntryByKey(key);
        return entryByKey == null ? null : entryByKey.value();
    }

    public int size() {
        return entries.size();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

}
