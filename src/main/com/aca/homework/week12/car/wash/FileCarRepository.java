package com.aca.homework.week12.car.wash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileCarRepository implements CarRepository {

    private final static String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/car/wash/";
    private final String name;
    private final Map<Object, Integer> washedCars;

    public FileCarRepository(String name) {
        this.name = name;
        this.washedCars = new HashMap<>();
    }

    @Override
    public void save(Object data) {

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(PATH + name + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException("Not found file " + name + ".txt in " + PATH, e);
        }

        if (!washedCars.containsKey(data) || washedCars.get(data) == 5) {
            washedCars.put(data, 1);
        } else {
            washedCars.put(data, washedCars.get(data) + 1);
        }

        for (Object o : washedCars.keySet()) {
            try {
                objectOutputStream.writeObject(o);
                objectOutputStream.writeObject(washedCars.get(o));
            } catch (IOException e) {
                throw new RuntimeException("Failed to write", e);
            }
        }

        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close", e);
        }
    }

    @Override
    public Object load() {

        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(PATH + name + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException("Not found file " + name + ".txt in " + PATH, e);
        }

        washedCars.clear();
        while (true) {
            try {
                washedCars.put(objectInputStream.readObject(), (Integer) objectInputStream.readObject());
            } catch (EOFException e) {
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    throw new RuntimeException("Failed to close", e);
                }
                return washedCars;
            } catch (IOException e) {
                throw new RuntimeException("Failed to read", e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found", e);
            }
        }
    }
}
