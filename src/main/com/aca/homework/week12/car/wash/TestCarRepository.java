package com.aca.homework.week12.car.wash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestCarRepository implements CarRepository {

    private String name;
    private final Map<Object, Integer> washedCars;

    public TestCarRepository() {
        this.washedCars = new HashMap<>();}

    @Override
    public void save(Object data) {

        if (!washedCars.containsKey(data) || washedCars.get(data) == 5) {
            washedCars.put(data, 1);
        } else {
            washedCars.put(data, washedCars.get(data) + 1);
        }

    }

    @Override
    public Object load() {
        return washedCars;
    }
}
