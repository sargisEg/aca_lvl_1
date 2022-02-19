package com.aca.homework.week3.numbersmaxmin;

public class Numbers {
    private int number1;
    private int number2;
    private int number3;

    public static void main(String[] args) {
        Numbers numbers = new Numbers(15,39,68);

        System.out.println(numbers.max());
        System.out.println(numbers.min());
    }

    public Numbers(int n1, int n2,int n3){
        number1 = n1;
        number2 = n2;
        number3 = n3;
    }

    public int max(){
        int max = number1;
        if (number2 > max) max = number2;
        if (number3 > max) max = number3;
        return max;
    }
    public int min(){
        int min = number1;
        if (number2 < min) min = number2;
        if (number3 < min) min = number3;
        return min;
    }
}

/*
Create a Numbers class that has number1, number2 and number3 private fields
and a constructor that takes 3 numbers and assign them to the mentioned fields.

Create a max() method that does not take any argument and returns a maximum value out of the 3 object fields.
Create a min() method that does not take any argument and returns a minimum value out of the 3 object fields
*/
