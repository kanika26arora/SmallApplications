package com.example.shop.demo.productCheckout;

public class Product {

    private int id;

    private String name;
    private double price;

    ProductCategory productCategory;

    public Product(int id, String name, double price, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
