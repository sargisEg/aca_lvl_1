package com.aca.homework.week10.concrete.map;

public class Entry {

    private final String key;
    private final String value;

    private Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Entry of(String key, String value) {
        return new Entry(key, value);
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }


}
