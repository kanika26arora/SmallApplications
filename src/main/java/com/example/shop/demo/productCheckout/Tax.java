package com.example.shop.demo.productCheckout;

import java.util.HashMap;
import java.util.Map;

public class Tax {
    private static final Map<ProductCategory, Double> taxRates = new HashMap<>();

    static {
        taxRates.put(ProductCategory.SPECIAL, 0.10);
        taxRates.put(ProductCategory.NORMAL, 0.15);
        // Add more categories and tax rates as needed
    }

    public static double getTaxRate(ProductCategory category) {
        return taxRates.getOrDefault(category, 0.0);
    }
}
