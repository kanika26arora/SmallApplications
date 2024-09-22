package com.example.shop.demo.productCheckout;

public class FlatRateDiscountImplementor extends DiscountImplementor{
    @Override
    double applyDiscount(double amount, double basePrice) {
        return (basePrice - amount);
    }
}
