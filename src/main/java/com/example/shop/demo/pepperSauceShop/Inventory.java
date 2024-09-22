package com.example.shop.demo.pepperSauceShop;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    public static void main(String... s){

        List<Location> locationList = new ArrayList<>();

        Map<Pepper, Integer> torontoMap = new HashMap<>();
        torontoMap.put(Pepper.J, 5);
        torontoMap.put(Pepper.H, 0);
        torontoMap.put(Pepper.S, 0);
        Location toronto = new Location("Toronto", torontoMap);


        Map<Pepper, Integer> VancouverMap = new HashMap<>();
        VancouverMap.put(Pepper.J, 10);
        VancouverMap.put(Pepper.H, 2);
        VancouverMap.put(Pepper.S, 6);
        Location vancouver = new Location("Vancouver", VancouverMap);


        Map<Pepper, Integer> MontrealMap = new HashMap<>();
        MontrealMap.put(Pepper.J, 3);
        MontrealMap.put(Pepper.H, 5);
        MontrealMap.put(Pepper.S, 5);
        Location Montreal = new Location("Montreal", MontrealMap);

        Map<Pepper, Integer> CalgaryMap = new HashMap<>();
        CalgaryMap.put(Pepper.J, 1);
        CalgaryMap.put(Pepper.H, 18);
        CalgaryMap.put(Pepper.S, 2);
        Location Calgary = new Location("Calgary", CalgaryMap);

        Map<Pepper, Integer> HalifaxMap = new HashMap<>();
        HalifaxMap.put(Pepper.J, 28);
        HalifaxMap.put(Pepper.H, 2);
        HalifaxMap.put(Pepper.S, 12);
        Location Halifax = new Location("Halifax", HalifaxMap);

        locationList.add(toronto);
        locationList.add(vancouver);
        locationList.add(Montreal);
        locationList.add(Calgary);
        locationList.add(Halifax);

        Map<Pepper, Integer> inputMap = new HashMap<>();
        inputMap.put(Pepper.J, 3);
        inputMap.put(Pepper.H, 2);
        inputMap.put(Pepper.S, 4);

        Map<Pepper, Integer> inputMap2 = new HashMap<>();
        inputMap2.put(Pepper.H, 7);
        inputMap2.put(Pepper.S, 1);


        //List<String> result = getStock(inputMap, locationList);

        List<String> result = getStock(inputMap2, locationList);

        for(String st: result){
            System.out.println(st);
        }


    }

    static List<String>  getStock(Map<Pepper, Integer> inputMap, List<Location> locationList){

        List<String>  result = new ArrayList<>();

        for(Location location: locationList){

            boolean canFulfill = inputMap.entrySet().stream().allMatch(pepperIntegerEntry ->
                    location.sauceMap.get(pepperIntegerEntry.getKey()) >=
                            pepperIntegerEntry.getValue()
            );

            if(canFulfill){
                result.add(location.name);
            }
        }
        return result;
    }
}
