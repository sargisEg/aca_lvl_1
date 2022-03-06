package com.aca.homework.week8.product.repository;

public class ProductAlreadyExistsException extends RuntimeException {

    public ProductAlreadyExistsException(Product product) {
        super("Product " + product + " already exist");
    }
}
