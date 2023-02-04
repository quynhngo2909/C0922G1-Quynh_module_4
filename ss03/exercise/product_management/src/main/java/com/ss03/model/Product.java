package com.ss03.model;

public class Product {
    private int id;
    private String name;
    private Double price;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, Double price, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
