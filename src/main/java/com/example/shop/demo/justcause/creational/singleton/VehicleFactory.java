package com.example.shop.demo.justcause.creational.singleton;

public class VehicleFactory {

    private Vehicle vehicle;

    public static Vehicle getInstance(Vehicle name){
        if(name instanceof TwoWheelerVehicle){
            return new TwoWheelerVehicle();
        } else{
            return new FourWheelerVehicle();
        }
    }


}
