package com.aca.homework.week12.temperature;

import java.io.*;

public class DailyTemperatureFileItemReader implements ItemReader<DailyTemperature> {

    private static final String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/temperature/";
    private FileInputStream fileInputStream = null;

    @Override
    public DailyTemperature read() {

        if (fileInputStream == null) {
            try {
                fileInputStream = new FileInputStream((PATH + "daily-temp-data.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Not found file in " + PATH, e);
            }
        }

        ObjectInputStream objectInputStream = null;

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

