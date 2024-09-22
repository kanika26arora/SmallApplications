package com.example.shop.demo.ParkingLotApplication;

public abstract class ParkingSpot {

    int id;
    protected Vehicle vehicle;
    protected SpotType spotType;
    protected boolean isFree;

    protected int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle v) {
        this.vehicle = v;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpot(int id, Vehicle vehicle, SpotType spotType) {
        this.id = id;
        this.vehicle = vehicle;
        this.spotType = spotType;
        this.isFree = false;
    }
}
