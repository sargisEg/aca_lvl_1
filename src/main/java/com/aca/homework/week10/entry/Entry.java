package com.aca.homework.week10.entry;

public interface Entry<K, V> {

    K key();

    V value();

    static <K, V> Entry<K, V> of(K k, V v) {
        return new EntryImpl<>(k, v);
    }

}
