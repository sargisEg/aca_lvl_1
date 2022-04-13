package com.aca.homework.week7.additional_number;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalNumberTest {

    public static void main(String[] args) {
        int[] first = {5, -2, -3, 1, -4};
        int[] second = {-4, 5, 1, -2};
        System.out.println(AdditionalNumber.findAdditionalNum(first, second));
    }

}