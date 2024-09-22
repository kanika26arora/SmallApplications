package com.example.shop.demo.productCheckout;

public class DiscountFactory {

    public static DiscountImplementor getDiscountImplementor(DiscountCategory discountCategory){

        if(discountCategory.equals(DiscountCategory.PERCENTAGE)){
            return new PercentageDiscountImplementor();
        } else {
            return new FlatRateDiscountImplementor();
        }

    }
}
