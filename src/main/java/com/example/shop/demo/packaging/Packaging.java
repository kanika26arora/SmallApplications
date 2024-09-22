package com.example.shop.demo.packaging;

import java.util.*;

public class Packaging {

    static Map<Item, LinkedHashMap<Box, Integer>> inventory = new HashMap<>();

    static {
        LinkedHashMap<Box, Integer> camMap = new LinkedHashMap<>();
        camMap.put(Box.M, 1);
        camMap.put(Box.L, 2);


        LinkedHashMap<Box, Integer> gameMap = new LinkedHashMap<>();
        gameMap.put(Box.M, 0);
        gameMap.put(Box.L, 2);


        LinkedHashMap<Box, Integer> blueMap = new LinkedHashMap<>();
        blueMap.put(Box.M, 0);
        blueMap.put(Box.L, 1);


        inventory.put(Item.Cam, camMap);
        inventory.put(Item.Game, gameMap);
        inventory.put(Item.Blue, blueMap);
    }

    public List<ItemInBox> getResult(List<Item> input){

        Map<Item, Integer> inputFreq = convertToMap(input);

        List<ItemInBox> result = new ArrayList<>();

        for(Map.Entry<Item, Integer> inputItem: inputFreq.entrySet()){

            if(inventory.containsKey(inputItem.getKey())){

                int numberOfItems = inputItem.getValue();

                while (numberOfItems > 0){

                    for(Map.Entry<Box, Integer> boxesInInventory: inventory.get(inputItem.getKey()).entrySet()){

                        int boxCapacity = boxesInInventory.getValue();

                        if(boxCapacity == 0)
                            continue;

                        if(numberOfItems <= boxCapacity){


                            List<Item> itemList = new ArrayList<>();

                            for(int i=0; i<numberOfItems; i++) {
                                itemList.add(inputItem.getKey());

                            }

                            result.add(new ItemInBox(boxesInInventory.getKey(), itemList));
                            numberOfItems = 0;

                        } else if(!boxesInInventory.getKey().equals(Box.M)){

                            int numberOfBoxesRequired = numberOfItems / boxCapacity;

                            for (int i = 0; i < numberOfBoxesRequired; i++) {
                                ItemInBox itemInBox = null;

                                List<Item> itemList = new ArrayList<>();

                                for (int j = 0; j < boxCapacity; j++) {
                                    itemList.add(inputItem.getKey());
                                }
                                itemInBox = new ItemInBox(boxesInInventory.getKey(), itemList);

                                result.add(itemInBox);

                            }
                            numberOfItems = numberOfItems%boxCapacity;
                        }
                    }
                }
            } else{
                throw new IllegalArgumentException(inputItem.getKey().name() + " doesnt exist");
            }
        }
        return result;

    }


    Map<Item, Integer> convertToMap(List<Item> input){

        Map<Item, Integer> inputFreq = new HashMap<>();

        for(Item item: input){
            inputFreq.put(item, inputFreq.getOrDefault(item, 0) + 1);
        }

        return inputFreq;

    }
}
