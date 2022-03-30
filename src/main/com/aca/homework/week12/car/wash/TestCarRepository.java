package com.aca.homework.week12.car.wash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestCarRepository implements CarRepository {

    private String name;
    private final CarData carData;

    public TestCarRepository() {
        this.carData = new CarData();
    }

    @Override
    public void save(Object data) {
        carData.add(data);
    }

    @Override
    public Object load() {
        return carData.getData();
    }
}
