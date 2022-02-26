package com.aca.homework.week7.additional_number;

public class AdditionalNumber {

    public static int findAdditionalNum(int[] first, int[] second) {

        int additionalNum = 0;

        for (int i = 0; i < second.length; i++) {
            additionalNum += first[i] - second[i];
        }
        additionalNum += first[first.length-1];

        return additionalNum;
    }
}
