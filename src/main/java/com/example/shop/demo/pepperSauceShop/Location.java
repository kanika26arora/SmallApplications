package com.example.shop.demo.pepperSauceShop;

import java.util.Map;

public class Location {

    String name;
    Map<Pepper, Integer> sauceMap;

    Location(String name, Map<Pepper, Integer> sauceMap){
        this.name = name;
        this.sauceMap = sauceMap;
    }
}
