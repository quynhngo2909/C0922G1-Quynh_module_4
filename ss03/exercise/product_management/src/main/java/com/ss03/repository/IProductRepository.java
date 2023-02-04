package com.ss03.repository;

import com.ss03.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> products();
    List<String> producers();
    boolean save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product findById(int id);
    Product findByName(String name);
}
