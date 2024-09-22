package com.example.shop.demo.packaging;

import java.util.List;

public class ItemInBox {
    public Box getBox() {
        return box;
    }

    public ItemInBox(Box box, List<Item> itemList) {
        this.box = box;
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    Box box;
    List<Item> itemList;
}
