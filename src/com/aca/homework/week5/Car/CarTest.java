package com.aca.homework.week5.Car;

import java.util.Scanner;

public class CarTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] cars = new Object[5];
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Enter " + (i+1) + " car width");
            int width = scanner.nextInt();
            System.out.println("Enter " + (i+1) + " car wight");
            int wight = scanner.nextInt();
            System.out.println("Enter " + (i+1) + " car color");
            String color = scanner.next();
            System.out.println("Enter " + (i+1) + " car brand");
            String name = scanner.next();
            if(name.equals("bmw")){
                cars[i] = new BMW(width, wight,color,name);
            }
            if (name.equals("hyundai")){
                cars[i] = new Hyundai(width, wight,color,name);
            }
        }
        print(cars);

    }

    public static void print(Object[] o){
        for (int i = 0; i < o.length; i++) {
            System.out.print((i+1) + ") " + o[i] + "\n");
        }
    }
}


/*
Ask a user to input color, width, weight and brand name 5 times,
create a car object based on the input fields and add them in an array.
if the inputed brand name is other than 'bmw' or 'hyundai' just ignore it and do not create an object.

Create a method that takes array of objects and for each object print the following

"1) brand: bmw, white: red, width: 5, wight 1200"
"2) brand: hyundai, color: red, width: 5, wight 1300"
..
"5) brand: bmw, color: black, width: 6, wight 1500" */

