package com.aca.homework.week8.max.product;

import java.math.BigDecimal;

public class MaxProduct {
    public static String calculateMaxProduct(int[] array) {

        if(array == null || array.length == 0)
            throw new IllegalArgumentException();

        BigDecimal product = BigDecimal.valueOf(1);
        int maxNegativeNumber = 1;
        int notNullNumbersCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                notNullNumbersCount++;
                product = product.multiply(BigDecimal.valueOf(array[i]));
            }
            if (array[i] < 0) {
                if (maxNegativeNumber == 1 || maxNegativeNumber < array[i])
                    maxNegativeNumber = array[i];
            }
        }

        if (array.length == 1 && array[0] < 0)
            return "0";

        if (notNullNumbersCount == 0)
            return "0";

        if (notNullNumbersCount == 1 && product.compareTo(BigDecimal.valueOf(0)) < 0)
            return "0";

        if (product.compareTo(BigDecimal.valueOf(0)) < 0)
            product = product.divide(BigDecimal.valueOf(maxNegativeNumber));

        return product.toString();
    }
}
