package com.aca.homework.week6.buffer;

import java.util.Objects;

public class BufferImpl implements Buffer{

    private Object myObject;

    @Override
    public void put(Object newObject) {
        if (myObject == null)
            this.myObject = newObject;
        else
            System.out.println("The buffer is not empty");
    }

    @Override
    public Object get() {
        if (myObject == null){
            System.out.println("Buffer is empty");
        }
        Object returnObject = myObject;
        myObject = null;
        return returnObject;
    }

    @Override
    public String toString() {
        return "Buffer object: " + myObject.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this.myObject == o) return true;
        if (o == null || myObject.getClass() != o.getClass()) return false;
        return this.myObject.equals(o);
    }

}
