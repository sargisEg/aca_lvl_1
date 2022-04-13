package com.aca.homework.week12.temperature;

import java.io.*;

public class DailyTemperatureFileItemReader implements ItemReader<DailyTemperature> {

    private static final String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/temperature/";
    private final FileInputStream fileInputStream;

    public DailyTemperatureFileItemReader(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @Override
    public DailyTemperature read() {
        ObjectInputStream objectInputStream;

        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Not found file in " + PATH, e);
        }

        try {
            int day = objectInputStream.readInt();
            float temp = objectInputStream.readFloat();
            objectInputStream.readChar();
            return new DailyTemperature(day, temp);
        } catch (EOFException e1) {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to close", e);
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }
    }
}

