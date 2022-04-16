package com.aca.homework.week11.map.performance;

import java.util.HashMap;
import java.util.Map;

public class LowPerformanceMapValueCountCalculator implements MapValueCountCalculator {

    private final Map<String, Integer> strings = new HashMap<>();
    
    @Override
    public StringOccurrence populateAndCalculate(int numberOfRandomStrings) {
        Randomizer randomizer = new Randomizer();
        StringOccurrence stringOccurrence = new StringOccurrence();

        for (int i = 0; i < numberOfRandomStrings; i++) {
            String stringKey = randomizer.get8SizedString();
            if (strings.containsKey(stringKey)) {
                int keyCount = strings.get(stringKey) + 1;
                strings.put(stringKey, keyCount);
                stringOccurrence.checkMaxMinOccurrence(stringKey, keyCount);
            } else {
                strings.put(stringKey, 1);
                stringOccurrence.checkMaxMinOccurrence(stringKey, 1);
            }
        }
        return stringOccurrence;
    }
}
