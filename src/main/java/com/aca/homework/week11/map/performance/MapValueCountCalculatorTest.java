package com.aca.homework.week11.map.performance;

import java.util.Scanner;

public class MapValueCountCalculatorTest {

    public static void main(String[] args) {
        MapValueCountCalculator mapValueCountCalculator;
        Scanner scanner = new Scanner(System.in);
        String type = "";
        while (!(type.equals("high") || type.equals("low"))) {
            System.out.print("Type instance type ('low' or 'high'): ");
            type = scanner.next();
        }
        System.out.print("Type number of strings: ");
        int numberOfStrings = scanner.nextInt();

        if(type.equals("high")) {
            mapValueCountCalculator = new HighPerformanceMapValueCountCalculator();
        } else {
            mapValueCountCalculator = new LowPerformanceMapValueCountCalculator();
        }

        long start = System.currentTimeMillis();
        mapValueCountCalculator.populateAndCalculate(numberOfStrings).print();
        System.out.println(System.currentTimeMillis() - start);

    }
}
