package com.aca.homework.week12.temperature;

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
        ItemReader<DailyTemperature> reader = new DailyTemperatureFileItemReader();
        for (int i = 1; i < 366; i++) {
            dailyTemperatures.add(reader.read());
        }

        System.out.println(dailyTemperatures);
    }
}
