package com.aca.homework.week12.car.wash;

import java.io.*;
import java.util.Map;

public class FileCarRepository implements CarRepository {

    private final static String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/car/wash/";
    private final String name;
    private final CarData washedCars = new CarData();

    public FileCarRepository(String name) {
        this.name = name;
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

        washedCars.add(data);

        try {
            objectOutputStream.writeObject(washedCars.getData());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write", e);
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

        while (true) {
            try {
                washedCars.loadNewData((Map<Object, Integer>) objectInputStream.readObject());
            } catch (EOFException e) {
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    throw new RuntimeException("Failed to close", e);
                }
                return washedCars.getData();
            } catch (IOException e) {
                throw new RuntimeException("Failed to read", e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Class not found", e);
            }
        }
    }
}
