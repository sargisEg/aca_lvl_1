package com.aca.homework.week8.product.repository;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
