package com.aca.homework.week6.buffer;


public class BufferTest {
    public static void main(String[] args) {
        Object o = new Object();
        String str = new String("text");
        MyTestClass myTestClass = new MyTestClass(65);

        Buffer buffer = new BufferImpl();
        buffer.get();
        buffer.put(o);
        buffer.put(myTestClass);
        buffer.get();
        buffer.put(str);
    }
}
