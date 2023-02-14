package com.ss10.product_cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean isItemInCart(Product product) {
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            if (product.getId().equals(e.getKey().getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectProductInCart(Product product) {
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            if(product.getId().equals(e.getKey().getId())){
                return e;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!isItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectProductInCart(product);
            products.replace(itemEntry.getKey(), itemEntry.getValue() + 1);
        }
    }

    public Integer countProductQty(){
        Integer productQty = 0;
        for (Map.Entry<Product,Integer> e : products.entrySet()) {
            productQty += e.getValue();
        }
        return productQty;
    }

    public Integer countItemQty(){
        return products.size();
    }

    public  Double countTotalPayment(){
        double payment = 0;
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            payment += e.getKey().getPrice() * e.getValue();
        }

        return  payment;
    }
}
