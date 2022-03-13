package com.aca.homework.week10.entry;

public class EntryImpl<K, V> implements Entry<K, V> {

    private K key;
    private V value;

    public EntryImpl(K k, V v) {
        key = k;
        value = v;
    }

    @Override
    public K key() {
        return key;
    }

    @Override
    public V value() {
        return value;
    }
}
