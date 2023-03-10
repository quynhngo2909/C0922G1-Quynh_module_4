package com.ss03.repository.impl;

import com.ss03.model.Product;
import com.ss03.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products;
    private static List<String> producerList;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Phone1", 1000.0, "Apple"));
        products.put(2, new Product(2, "Phone2", 2000.0, "SamSung"));
        products.put(3, new Product(3, "Phone3", 3000.0, "LG"));
        products.put(4, new Product(4, "Phone4", 4000.0, "Oppo"));
        products.put(5, new Product(5, "Phone5", 5000.0, "Apple"));
    }

    static {
        producerList = new ArrayList<>();
        producerList.add("Apple");
        producerList.add("SamSung");
        producerList.add("LG");
        producerList.add("Oppo");
        producerList.add("Huawei");
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<String> getProducers() {
        return producerList;
    }
    @Override
    public boolean save(Product product) {
        boolean isNewProduct = false;
        if (products.get(product.getId()) == null) {
            isNewProduct = true;
            products.put(product.getId(), product);
        }
        return isNewProduct;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry: products.entrySet()){
            if(entry.getValue().getName().toLowerCase().contains(name.toLowerCase())){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
