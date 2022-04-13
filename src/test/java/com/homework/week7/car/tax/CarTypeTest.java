package com.homework.week7.car.tax;

import com.aca.homework.week7.car.tax.CarType;

class CarTypeTest {
    public static void main(String[] args) {
        CarType electricCar = CarType.ELECTRIC;
        CarType hybridCar = CarType.HYBRID;

        System.out.println(electricCar.annualTex(7));
        System.out.println(hybridCar.annualTex(12));
    }
}