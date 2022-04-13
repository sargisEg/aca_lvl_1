package com.aca.homework.week8.product.repository;

@Repository
public interface ProductRepository {

    void save(Product product);

    @Nulable
    Product findById(Long id);

    @NotNull
    Product getById(Long Id);
}
