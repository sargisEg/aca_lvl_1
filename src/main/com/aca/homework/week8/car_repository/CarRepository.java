package com.aca.homework.week8.car_repository;

public class CarRepository {

    private Car[] cars = new Car[1000];
    private int pointer = 0;

    public Car save(Car car) {
        for (int i = 0; i < pointer; i++) {
            if (cars[i].equals(car)) {
                cars[i].update(car);
                return cars[i];
            }
        }
        cars[pointer] = car;
        pointer++;
        return cars[pointer -1];
    }

    public Car findByVin(String vin) {
        if(pointer == 0)
            return null;
        for (int i = 0; i < pointer; i++) {
            if(cars[i].getVin().equals(vin))
                return cars[i];
        }
        return null;
    }

    public int getTotalCount() {
        return pointer;
    }
}
