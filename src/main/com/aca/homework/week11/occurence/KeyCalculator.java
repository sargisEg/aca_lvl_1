package com.aca.homework.week11.occurence;

import java.util.HashMap;
import java.util.Map;

public class KeyCalculator {

    private final Map<Integer, Integer> occurrencesMap = new HashMap<>();
    private final NumberSupplier numberSupplier;

    public KeyCalculator(NumberSupplier numberSupplier) {
        this.numberSupplier = numberSupplier;
    }

    public Integer getValue(int key) {
        return occurrencesMap.get(key);
    }

    public Map<Integer, Integer> askAndCalculate() {
        while (true) {
            String input = numberSupplier.getNumber();
            if (input.equals("end")) {
                System.out.println(occurrencesMap);
                return occurrencesMap;
            }
            Integer key = null;

            try {
                key = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
                continue;
            }
            
            if (occurrencesMap.containsKey(key)) {
                occurrencesMap.put(key, occurrencesMap.get(key) + 1);
            } else {
                occurrencesMap.put(key, 1);
            }
        }
    }
}
