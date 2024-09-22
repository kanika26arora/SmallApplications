package com.example.shop.demo;


import com.example.shop.demo.guildedRose.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

@SpringBootTest
public class GildedRoseTest {

    static Map<String, ItemStrategy> strategies;

    static {

        strategies = new HashMap<>();
        strategies.put("Normal Item", new DefaultItemStrategy());
        strategies.put("Aged Brie", new AgedBrieItemStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassItemStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasItemStrategy());

    }

    @Test
    public void testNormalItemBeforeSellIn() {
        
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };

        for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    public void testNormalItemOnSellIn() {
        Item[] items = new Item[] { new Item("Normal Item", 1, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(0, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    public void testNormalItemAfterSellIn() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    public void testNormalItemWithZeroQuality() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void testConjuredItem() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };

        for(Item item: items){
            ItemStrategy itemStrategy = strategies.getOrDefault(item.name, new DefaultItemStrategy());
            itemStrategy.update(item);
        }
        assertEquals(2, items[0].sellIn);
        assertEquals(5, items[0].quality);
    }

    @Test
    public void testAgedBrieBeforeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(9, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    public void testAgedBrieOnSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(0, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    public void testAgedBrieAfterSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(-1, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    public void testAgedBrieWithMaxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void testBackstagePassesLongBeforeSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    public void testBackstagePassesMediumBeforeSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    public void testBackstagePassesShortBeforeSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    public void testBackstagePassesOnSellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
         for(Item item: items){
            ItemStrategy itemStrategy = strategies.get(item.name);
            itemStrategy.update(item);
        }
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

}

