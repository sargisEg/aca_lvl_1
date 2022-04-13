package com.aca.homework.week5.car;

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

//    private Car(Builder builder) {
//        this.width = builder.width;
//        this.weight = builder.weight;
//        this.color = builder.color;
//        this.brandName = builder.brandName;
//    }

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
        return "Brand name: " + getBrandName() +
                ", color: " + getColor() +
                ", width: " + getWidth() +
                ", weight: " + getWeight();
    }

//    public static class Builder {
//        private int width = 0;
//        private int weight = 0;
//        private String color = "";
//        private String brandName = "";
//
//        public Builder width(int val) {
//            this.width = val;
//            return this;
//        }
//
//        public Builder weight(int val) {
//            this.weight = val;
//            return this;
//        }
//
//        public Builder color(String val) {
//            this.color = val;
//            return this;
//        }
//
//        public Builder brandName(String val) {
//            this.brandName = val;
//            return this;
//        }
//        public Car build() {
//            return new Car(this);
//        }
//    }
}

/*
Create Car class that has color, width, weight, and brand fields and getters only.
All fields of the Car class should be initialized within a constructor.

Create Hyundai and Bmw subclasses.
Implement toString methods in Car class.
*/
