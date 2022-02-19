package com.aca.homework.week6.myinteger;

public class MyInteger {
    private static final MyInteger[] myIntegerCache = new MyInteger[201];
    private  int value;

    private MyInteger(int value) {
        this.value = value;
    }

    public static MyInteger valueOf(int value) {
        if (value < 0) {
            if (myIntegerCache[value * -1] == null) {
                myIntegerCache[value * -1] = new MyInteger(value);
            }
            return myIntegerCache[value * -1];
        } else {
            if (myIntegerCache[value + 100] == null) {
                myIntegerCache[value + 100] = new MyInteger(value);
            }
            return myIntegerCache[value + 100];
        }
    }
}

/*
Create a MyInteger class that holds an int value.
Create a static factory named valueOf that takes a value and returns MyInteger.
Cache MyInteger classes for values -100 to 100.
e.g. if MyInteger.valueof(10) is invoked then the method should create and return a new object.
 If it is invoked once again then a new object should not be created but the old created one should be returned.
 */
