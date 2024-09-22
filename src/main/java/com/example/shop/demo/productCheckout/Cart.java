package com.example.shop.demo.productCheckout;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int id;

    private final List<Product> cartList;

    private final List<CheckoutState> checkoutStateList;

    private double totalPrice;

    public Cart(int id) {
        this.id = id;
        this.cartList = new ArrayList<>();
        this.checkoutStateList = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.cartList.add(product);
    }

    void removeProduct(Product product){
        this.cartList.remove(product);
    }

    public List<CheckoutState> getCheckoutStateList() {
        return checkoutStateList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double checkout(DiscountCategory discountCategory, double discountAmount){

        for(Product p : this.cartList){

            CheckoutState checkoutState = new CheckoutState();

            double priceAfterDiscount = applyDiscount(discountCategory, discountAmount, p.getPrice());
            double priceAfterTax = applyTax(p.productCategory, priceAfterDiscount);

            checkoutState.product = p;
            checkoutState.basePrice = p.getPrice();
            checkoutState.priceAfterDiscount = priceAfterDiscount;
            checkoutState.priceAfterTax = priceAfterTax;

            checkoutStateList.add(checkoutState);

            totalPrice += priceAfterTax;
        }

        return totalPrice;
    }

    double applyDiscount(DiscountCategory discountCategory, double discountAmount, double basePrice){

        return DiscountFactory.getDiscountImplementor(discountCategory).applyDiscount(discountAmount, basePrice);
    }

    double applyTax(ProductCategory productCategory, double priceAfterDiscount){
        double taxRate = Tax.getTaxRate(productCategory);
        return priceAfterDiscount + (taxRate * priceAfterDiscount);
    }
}
