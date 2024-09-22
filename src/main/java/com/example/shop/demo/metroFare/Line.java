package com.example.shop.demo.metroFare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {

    private final int id;

    private final List<Station> stationList;

    Map<String, Integer> stationMap;

    public int getId() {
        return id;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public Line(int id, List<Station> stationList) {
        this.id = id;
        this.stationList = stationList;

        this.stationMap = new HashMap<>();

        for(int i=0; i<stationList.size(); i++){
            stationMap.put(stationList.get(i).name, i);
        }
    }
}
