package com.aca.homework.week12.car.wash;

import java.util.Map;

public class CarWash {

    private final String name;
    private final CarRepository carRepository;

    public CarWash(String name, CarRepository carRepository) {
        this.name = name;
        this.carRepository = carRepository;
        carRepository.load();
    }

    public String getName() {
        return name;
    }

    public double wash(String plateNumber) {
        carRepository.save(plateNumber);
        Map<Object, Integer> loadedCars = (Map<Object, Integer>) carRepository.load();
        if(loadedCars.get(plateNumber) == 5) {
            return 0;
        }
        return 3.5;
    }
}
