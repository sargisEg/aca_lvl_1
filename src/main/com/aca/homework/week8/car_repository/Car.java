package com.aca.homework.week8.car_repository;

public class Car {
    private String vin;
    private int year;
    private int ownersCount;

    public Car(String vin, int year) {
        this.vin = vin;
        this.year = year;
    }

    public void update(Car car) {
        this.year = car.year;
        this.ownersCount = car.ownersCount;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Car) {
            Car car = (Car) o;
            return this.vin.equals(car.vin);
        }
        return false;
    }

    public void addOwnersCount() {
        ownersCount++;
    }
}