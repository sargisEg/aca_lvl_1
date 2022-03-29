package com.aca.homework.week11.unique.cars;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private final String brand;
    private final String name;

    public Car(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    @Override
    public int compareTo(Car o) {
        if(this.brand.compareTo(o.brand) == 0) {
            return this.name.compareTo(o.name);
        }
        return this.brand.compareTo(o.brand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof Car) {
            return Objects.equals(name, ((Car) o).name) && Objects.equals(brand, ((Car) o).brand);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
