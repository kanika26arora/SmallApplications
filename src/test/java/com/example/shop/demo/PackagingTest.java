package com.example.shop.demo;

import com.example.shop.demo.packaging.Box;
import com.example.shop.demo.packaging.Item;
import com.example.shop.demo.packaging.ItemInBox;
import com.example.shop.demo.packaging.Packaging;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class PackagingTest {

    @Test
    public void test1(){

        Packaging packaging = new Packaging();

        List<Item> input = new ArrayList<>();
        input.add(Item.Cam);


        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test2(){

        Packaging packaging = new Packaging();

        List<Item> input = new ArrayList<>();
        input.add(Item.Cam);
        input.add(Item.Game);


        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test3(){

        Packaging packaging = new Packaging();

        List<Item> input = new ArrayList<>();

        input.add(Item.Game);
        input.add(Item.Blue);


        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test4(){

        Packaging packaging = new Packaging();

        List<Item> input = List.of(Item.Game, Item.Game, Item.Blue);


        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test5(){

        Packaging packaging = new Packaging();

        List<Item> input = List.of(Item.Game, Item.Game, Item.Cam, Item.Cam);

        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test6(){

        Packaging packaging = new Packaging();

        List<Item> input = List.of(Item.Cam, Item.Cam, Item.Cam, Item.Game, Item.Game, Item.Game, Item.Cam, Item.Blue);

        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    @Test
    public void test7(){

        Packaging packaging = new Packaging();

        List<Item> input = List.of(Item.Cam, Item.Cam, Item.Cam, Item.Game, Item.Game, Item.Cam, Item.Cam, Item.Blue, Item.Blue);

        List<ItemInBox> result = packaging.getResult(input);

        print(result);

    }

    private void print(List<ItemInBox> result){

        for(ItemInBox itemInBox: result){

            System.out.print("[" + itemInBox.getBox() + "]: [");

            for(Item itemList : itemInBox.getItemList()){
                System.out.print(itemList.name() + ",");
            }

            System.out.print("]");

            System.out.println();

        }
    }
}
