package com.example.shop.demo.productCheckout;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Receipt {

    UUID id;

    Cart cart;

    Receipt(UUID id, Cart cart){
        this.id = id;
        this.cart = cart;
    }

    public static Receipt generateReceipt(Cart cart){

        return new Receipt(UUID.randomUUID(), cart);

    }


    public void printReceipt(Receipt receipt) {

        System.out.println("Receipt ID: " + id);
        System.out.println("-------------------------------------------------");
        for (CheckoutState checkoutState : receipt.cart.getCheckoutStateList()) {
            System.out.println("Product: " + checkoutState.getProduct().getName());
            System.out.println("Base Price: $" + checkoutState.getBasePrice());
            System.out.println("Price After Discount: $" + checkoutState.getPriceAfterDiscount());
            System.out.println("Price After Tax: $" + checkoutState.getPriceAfterTax());
            System.out.println("-------------------------------------------------");
        }
        System.out.println("Total Price: $" + receipt.cart.getTotalPrice());
    }
}
