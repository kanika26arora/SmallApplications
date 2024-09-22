package com.example.shop.demo.ParkingLotApplication;

public class Vehicle {

    private int number;

    private VehicleType vehicleType;

    public Vehicle(int number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }

    public int getNumber() {
        return number;
    }



    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }


}
