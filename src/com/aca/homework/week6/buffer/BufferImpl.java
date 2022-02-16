package com.aca.homework.week6.buffer;

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
    public boolean equals(Object o){
        if(o instanceof Buffer){
            return myObject.equals(o);
        }
        return false;
    }
}
