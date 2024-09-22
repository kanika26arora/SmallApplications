package com.example.shop.demo.productCheckout;

public class PercentageDiscountImplementor extends DiscountImplementor{
    @Override
    double applyDiscount(double amount, double basePrice) {

        return basePrice - (amount/100) * basePrice;
    }
}
