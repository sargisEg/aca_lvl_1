package com.aca.homework.week11.occurence;

import java.util.HashMap;
import java.util.Map;

public class KeyCalculator {

    private final Map<Integer, Integer> occurrencesMap = new HashMap<>();
    private NumberSupplier numberSupplier;

    public KeyCalculator(NumberSupplier numberSupplier) {
        this.numberSupplier = numberSupplier;
    }

    public Integer getValue(int key) {
        return occurrencesMap.get(key);
    }

    public void askAndCalculate() {
        while (true) {
            String input = numberSupplier.getNumber();
            if (input.equals("end")) {
                System.out.println(occurrencesMap);
                break;
            }
            try {
                Integer key = Integer.valueOf(input);
                if(occurrencesMap.containsKey(key)) {
                    occurrencesMap.put(key, occurrencesMap.get(key) + 1);
                } else {
                    occurrencesMap.put(key, 1);
                }
            } catch (NumberFormatException e) {

            }
        }
    }

    public static void main(String[] args) {
        new KeyCalculator(new UserNumberSupplier()).askAndCalculate();
    }
}
