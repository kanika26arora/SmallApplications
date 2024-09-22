package com.example.shop.demo.ParkingLotApplication;

public class FourWheelerParkingSpot extends ParkingSpot{

    FourWheelerParkingSpot(int id, Vehicle v, SpotType spotType){
        super(id, v, spotType);
        this.price = 2;
    }
}
