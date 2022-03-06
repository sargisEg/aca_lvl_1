package com.aca.homework.week8.product.repository;

import java.util.Objects;

public class Product {
    private String name;
    private long id;

    public Product(String name, long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " id: " + id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }
}
