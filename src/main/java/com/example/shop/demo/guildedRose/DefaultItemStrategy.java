package com.example.shop.demo.guildedRose;

public class DefaultItemStrategy extends ItemStrategy {

    @Override
    public void update(Item item) {

        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0){
            item.quality = item.quality - 1;
        }

    }
}
