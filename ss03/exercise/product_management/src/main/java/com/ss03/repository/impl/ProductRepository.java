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
    public List<Product> products() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<String> producers() {
        return producerList;
    }
    @Override
    public boolean save(Product product) {
        boolean isValidId = true;
        Set<Integer> keySet = products.keySet();
        for (Integer key : keySet) {
            if (product.getId() == key) {
                isValidId = false;
                break;
            }
        }
        if (isValidId) {
            products.put(product.getId(), product);
        }
        return isValidId;
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
    public Product findByName(String name) {
        int id = 0;
        List<Product> productArrayList = this.products();
        for (Product p:productArrayList) {
            if(name.equals(p.getName())) {
                id = p.getId();
            }
        }
        return this.findById(id);
    }
}
