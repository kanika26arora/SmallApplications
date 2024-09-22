package com.example.shop.demo.packaging;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemMapping {

    Item item;

    Map<Box, Integer> boxMap;

    ItemMapping(Item item){
        this.item = item;
        this.boxMap = new LinkedHashMap<>();
    }


}
