package com.aca.homework.week11.unique.cars;

import java.util.*;

public class Pool {

    private final NameSupplier nameInput;
    private final Set<Car> cars;

    public Pool(NameSupplier nameInput) {
        this.nameInput = nameInput;
        cars = new TreeSet<>();
    }

    public static void main(String[] args) {
        Pool pool = new Pool(new UserNameSupplier());
        pool.askAndCalculate();
        pool.print();
    }

    public Set<Car> askAndCalculate() {
        System.out.println("please type your name, the brand, and model of your car");
        String[] nameAndCar = nameInput.get().split(" ");

        while (!nameAndCar[0].equals("finish")) {
            if (nameAndCar.length != 3) {
                System.out.println("Pleas enter valid format");
            } else {
                cars.add(new Car(nameAndCar[1], nameAndCar[2]));
            }
            nameAndCar = nameInput.get().split(" ");
        }
        return cars;
    }

    public void print() {
        System.out.println("Number of unique brand and models: " + cars.size());
        System.out.println(cars);
    }

}
