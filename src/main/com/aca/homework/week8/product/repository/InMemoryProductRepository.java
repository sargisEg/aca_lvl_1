package com.aca.homework.week8.product.repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private static final int SIZE = 10_000;
    private Product[] products = new Product[SIZE];
    private int pointer;

    @Override
    public void save(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Product is null");
        for (int i = 0; i < pointer; i++) {
            if (products[i].equals(product))
                throw new ProductAlreadyExistsException(product.getId());
        }
        products[pointer] = product;
        System.out.println("Product saved");
        pointer++;

    }

    @Override
    public Product findById(Long id) {
        for (int i = 0; i < pointer; i++) {
            if (products[i].getId() == id)
                return products[i];
        }
        return null;
    }

    @Override
    public Product getById(Long id) {
        for (int i = 0; i < pointer; i++) {
            if (products[i].getId() == id)
                return products[i];
        }
        throw new ProductNotFoundException(id);
    }
}