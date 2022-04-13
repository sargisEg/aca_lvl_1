package com.aca.homework.week12.car.wash;

import java.util.HashMap;
import java.util.Map;

public class CarData {

    private final Map<Object, Integer> carsData;

    public CarData() {
        this.carsData = new HashMap<>();
    }

    public void add(Object keyOfDataToAdd) {

        if (!carsData.containsKey(keyOfDataToAdd) || carsData.get(keyOfDataToAdd) == 5) {
            carsData.put(keyOfDataToAdd, 1);
        } else {
            carsData.put(keyOfDataToAdd, carsData.get(keyOfDataToAdd) + 1);
        }
    }

    public void loadNewData(Map<Object, Integer> newCarsData) {
        carsData.clear();
        carsData.putAll(newCarsData);
    }

    public Map<Object, Integer> getData() {
        return carsData;
    }

    public Integer getCountByData(Object data) {
        return carsData.get(data);
    }
}
