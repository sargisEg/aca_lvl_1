package com.aca.homework.week10.entry;

class EntryImpl<K, V> implements Entry<K, V> {

    private K key;
    private V value;

    EntryImpl(K k, V v) {
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
