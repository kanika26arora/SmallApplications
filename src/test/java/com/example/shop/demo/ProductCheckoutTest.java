package com.example.shop.demo;

import com.example.shop.demo.productCheckout.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductCheckoutTest {

    @Test
    public void test1(){

        Product lotion = new Product(1, "Lotion", 20, ProductCategory.NORMAL);
        Product speaker = new Product(2, "speaker", 100, ProductCategory.SPECIAL);

        Cart cart = new Cart(1);
        cart.addProduct(lotion);
        cart.addProduct(speaker);

        double total = cart.checkout(DiscountCategory.FLAT, 5);
        assertEquals(99, total);

        Receipt receipt = Receipt.generateReceipt(cart);
        receipt.printReceipt(receipt);

    }

    @Test
    public void test2(){

        Product lotion = new Product(1, "Lotion", 20, ProductCategory.NORMAL);
        Product speaker = new Product(2, "speaker", 100, ProductCategory.SPECIAL);

        Cart cart = new Cart(1);
        cart.addProduct(lotion);
        cart.addProduct(speaker);

        double total = cart.checkout(DiscountCategory.PERCENTAGE, 10);
        assertEquals(97.2, total);

        Receipt receipt = Receipt.generateReceipt(cart);
        receipt.printReceipt(receipt);

    }
}
