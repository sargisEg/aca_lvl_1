package com.aca.homework.week8.car_repository;

public class CarRepository {

    private Car[] cars = new Car[1000];
    private int point = 0;

    public Car save(Car car) {
        for (int i = 0; i < point; i++) {
            if (cars[i].equals(car)) {
                cars[i].addOwnersCount();
                return cars[i];
            }
        }
        cars[point] = car;
        point++;
        return cars[point-1];
    }

    public Car findByVin(String vin) {
        if(point == 0)
            return null;
        for (Car car : cars) {
            if(car.getVin().equals(vin))
                return car;
        }
        return null;
    }

    public int getTotalCount() {
        return point;
    }
}
