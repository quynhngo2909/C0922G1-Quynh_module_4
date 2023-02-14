package com.ss10.product_cart.service;

import com.ss10.product_cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
}
