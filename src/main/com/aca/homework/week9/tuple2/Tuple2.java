package com.aca.homework.week9.tuple2;

public class Tuple2<T1, T2> {

    private T1 t1;
    private T2 t2;

    public Tuple2(T1 first, T2 second) {
        this.t1 = first;
        this.t2 = second;
    }

    public T1 getT1() {
        return t1;
    }

    public T2 getT2() {
        return t2;
    }
}
