package com.aca.homework.week5.equals;

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Mark", "Yorgantz");
        Owner owner2 = new Owner("Mark", "Tavares");

        Motorcycle yamaha = new Motorcycle(owner1, Brand.YAMAHA);
        Motorcycle yamaha1 = new Motorcycle(owner2, Brand.YAMAHA);

        System.out.println(yamaha);
        System.out.println(yamaha1);

        System.out.println(yamaha.equals(yamaha1));

    }
}

/*
    Create a Motorcycle of YAMAHA type owner of which is 'Yorgantz' 'Mark.
    Create a Motorcycle of YAMAHA type owner of which is 'Tavares 'Mark.
    print the above objects, compare them and print the result.
    */