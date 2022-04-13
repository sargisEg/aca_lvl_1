package com.aca.homework.week12.temperature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DailyTemperatureFileItemWriter implements ItemWriter<DailyTemperature> {

    private static final String PATH = "/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/temperature/";

    @Override
    public void write(DailyTemperature item) {

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH + "daily-temp-data.txt", true));
        } catch (IOException e) {
            throw new RuntimeException("Not found file in " + PATH, e);
        }

        try {
            objectOutputStream.writeInt(item.getDayNumber());
            objectOutputStream.writeFloat(item.getDegree());
            objectOutputStream.writeChar('\n');
        } catch (IOException e) {
            throw new RuntimeException("Failed to write", e);
        }

        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close", e);
        }
    }
}
