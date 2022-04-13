package com.aca.homework.week5.Car;

public class Car {

    private final int width;
    private final int weight;
    private final String color;
    private final String brandName;

    public Car(int width, int weight, String color, String brandName) {
        this.width = width;
        this.weight = weight;
        this.color = color;
        this.brandName = brandName;
    }

    public int getWeight() {
        return weight;
    }

    public int getWidth() {
        return width;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "Brand name: " + getBrandName()  +
                ", color: " + getColor() +
                ", width: " + getWidth() +
                ", weight: " + getWeight();
    }
}

/*
Create Car class that has color, width, weight, and brand fields and getters only.
All fields of the Car class should be initialized within a constructor.

Create Hyundai and Bmw subclasses.
Implement toString methods in Car class.
*/
