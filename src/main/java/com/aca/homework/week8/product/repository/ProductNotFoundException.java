package com.aca.homework.week8.product.repository;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(long id) {
        super("Product by " + id + " id not exist.");
    }
}
