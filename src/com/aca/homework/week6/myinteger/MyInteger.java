package com.aca.homework.week6.myinteger;

public class MyInteger {
    private int value;
    private static MyInteger[] unsignedCache = new MyInteger[101];
    private static MyInteger[] signedCache = new MyInteger[100];

    private MyInteger(int value) {
        this.value = value;
    }

    public static MyInteger valueOf(int value){
        if (value >= 0){
            if (unsignedCache[value] == null) {
                unsignedCache[value] = new MyInteger(value);
            }
            return unsignedCache[value];
        }else {
            if (signedCache[(value-1) * (-1)] == null) {
                signedCache[(value-1) * (-1)] = new MyInteger(value);
            }
            return signedCache[(value-1) * (-1)];
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
