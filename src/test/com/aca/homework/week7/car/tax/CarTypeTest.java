package com.aca.homework.week7.car.tax;

class CarTypeTest {
    public static void main(String[] args) {
        CarType electricCar = CarType.ELECTRIC;
        CarType hybridCar = CarType.HYBRID;

        System.out.println(electricCar.annualTex(7));
        System.out.println(hybridCar.annualTex(12));
    }
}