package com.aca.homework.week11.unique.cars;

import java.util.*;

public class Pool {

    private final NameInput nameInput;
    private final Set<String> cars;

    public Pool(NameInput nameInput) {
        this.nameInput = nameInput;
        cars = new TreeSet<>();
    }

    public static void main(String[] args) {
        Pool pool = new Pool(new UserNameInput());
        pool.askAndCalculate();
        pool.print();
    }

    public Set<String> askAndCalculate() {
        System.out.println("please type your name, the brand, and model of your car");
        String[] nameAndCar = nameInput.ask().split(" ");

        while (!nameAndCar[0].equals("finish")) {
            if (nameAndCar.length != 3) {
                System.out.println("Pleas enter valid format");
            } else {
                cars.add(nameAndCar[1] + " " + nameAndCar[2]);
            }
            nameAndCar = nameInput.ask().split(" ");
        }
        return cars;
    }

    public void print() {
        System.out.println("Number of unique brand and models: " + cars.size());
        System.out.println(cars);
    }

}
