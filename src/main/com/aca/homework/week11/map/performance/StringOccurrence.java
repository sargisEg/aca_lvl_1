package com.aca.homework.week11.map.performance;

public class StringOccurrence {

    private String maxOccurrenceString;
    private int maxOccurrenceStringCount;
    private String minOccurrenceString;
    private int minOccurrenceStringCount = 1;

    public void checkMaxMinOccurrence(String string, int count) {
        if(maxOccurrenceStringCount < count) {
            maxOccurrenceString = string;
            maxOccurrenceStringCount = count;
        }
        if(minOccurrenceStringCount >= count) {
            minOccurrenceString = string;
            minOccurrenceStringCount = count;
        }
    }

    public void print() {
        System.out.println("Max occurrence string: " + maxOccurrenceString + " occurrence count: " + maxOccurrenceStringCount);
        System.out.println("Min occurrence string: " + minOccurrenceString + " occurrence count: " + minOccurrenceStringCount);
    }

}
