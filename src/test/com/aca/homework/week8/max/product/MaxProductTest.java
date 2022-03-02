package com.aca.homework.week8.max.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductTest {

    /*
    case 1: 5 5 0 0 -9
    case 2: 5 -5 -5 -9 -1
    case 3: 0 0 0 1 0
    case 4: 0 0 0 -1 0
    case 5: 9 8 7 7
    case 6: -1
     */

    @Test
    public void case1Test() {
        int[] case1 = {5, 5, 0, 0, -9};
        Assertions.assertEquals("25", MaxProduct.calculateMaxProduct(case1));
    }

    @Test
    public void case2Test() {
        int[] case2 = {5, -5, -5, -9, -1};
        Assertions.assertEquals("1125", MaxProduct.calculateMaxProduct(case2));
    }

    @Test
    public void case3Test() {
        int[] case3 = {0, 0, 0, 1, 0};
        Assertions.assertEquals("1", MaxProduct.calculateMaxProduct(case3));
    }

    @Test
    public void case4Test() {
        int[] case4 = {0, 0, 0, -1, 0};
        Assertions.assertEquals("0", MaxProduct.calculateMaxProduct(case4));
    }

    @Test
    public void case5Test() {
        int[] case5 = {9, 8, 7, 7};
        Assertions.assertEquals("3528", MaxProduct.calculateMaxProduct(case5));
    }

    @Test
    public void case6Test() {
        int[] case6 = {-1};
        Assertions.assertEquals("0", MaxProduct.calculateMaxProduct(case6));
    }
}