package com.aca.homework.week8.max.product;

import java.math.BigDecimal;

public class MaxProduct {
    public static int calculateMaxProduct(int[] array) {

        if(array == null || array.length == 0)
            throw new IllegalArgumentException();

        BigDecimal product = BigDecimal.valueOf(1);
        int maxNegativeNumber = 1;
        int notZeroNumbersCount = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                notZeroNumbersCount++;
                product = product.multiply(BigDecimal.valueOf(array[i]));
            }
            if (array[i] < 0) {
                if (maxNegativeNumber == 1 || maxNegativeNumber < array[i])
                    maxNegativeNumber = array[i];
            }
        }

        if (array.length == 1)
            return array[0];

        if (notZeroNumbersCount == 0)
            return 0;

        if (notZeroNumbersCount == 1 && product.compareTo(BigDecimal.valueOf(0)) < 0)
            return 0;

        if (product.compareTo(BigDecimal.valueOf(0)) < 0)
            product = product.divide(BigDecimal.valueOf(maxNegativeNumber));

        return product.intValue();
    }
}
