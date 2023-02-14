package com.ss10.product_cart.service.impl;

import com.ss10.product_cart.model.Product;
import com.ss10.product_cart.repository.IProductRepository;
import com.ss10.product_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }
}
