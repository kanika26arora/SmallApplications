package com.example.shop.demo.productCheckout;

public class CheckoutState {

    Product product;
    double basePrice;
    double priceAfterDiscount;
    double priceAfterTax;

    public CheckoutState() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public double getPriceAfterTax() {
        return priceAfterTax;
    }

    public void setPriceAfterTax(double priceAfterTax) {
        this.priceAfterTax = priceAfterTax;
    }
}
