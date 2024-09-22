package com.example.shop.demo.ParkingLotApplication;

import java.util.List;

public class ParkingLotManagerFactory {

    static ParkingLotManager getInstance(VehicleType vehicleType, List<ParkingSpot> spots){

        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingLotManager(spots);
        } else{
            return new FourWheelerParkingLotManager(spots);
        }
    }
}
