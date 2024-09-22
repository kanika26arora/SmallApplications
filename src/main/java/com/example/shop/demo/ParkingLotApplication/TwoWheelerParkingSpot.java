package com.example.shop.demo.ParkingLotApplication;

public class TwoWheelerParkingSpot extends ParkingSpot{

    TwoWheelerParkingSpot(int id, Vehicle v, SpotType spotType){
        super(id, v, spotType);
        this.price = 1;
    }
}
