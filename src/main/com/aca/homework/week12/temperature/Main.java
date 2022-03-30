package com.aca.homework.week12.temperature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ItemWriter<DailyTemperature> writer = new DailyTemperatureFileItemWriter();
        Random random = new Random();
        for (int i = 1; i < 366; i++) {
            DailyTemperature dailyTemperature = new DailyTemperature(i, random.nextInt(30) - 15);
            writer.write(dailyTemperature);
        }

        List<DailyTemperature> dailyTemperatures = new LinkedList<>();
        ItemReader<DailyTemperature> reader = null;
        try {
            reader = new DailyTemperatureFileItemReader(new FileInputStream("/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week12/temperature/"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Not found file", e);
        }

        DailyTemperature temperature = reader.read();
        while (temperature != null) {
            dailyTemperatures.add(temperature);
            temperature = reader.read();
        }

        dailyTemperatures.forEach(System.out::println);
    }
}
