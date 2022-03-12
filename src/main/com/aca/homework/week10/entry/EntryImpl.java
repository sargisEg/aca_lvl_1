package com.aca.homework.week10.entry;

public class EntryImpl<K, V> implements Entry<K, V> {

    private K K;
    private V V;

    public EntryImpl(K k, V v) {
        K = k;
        V = v;
    }

    @Override
    public K key() {
        return K;
    }

    @Override
    public V value() {
        return V;
    }
}
