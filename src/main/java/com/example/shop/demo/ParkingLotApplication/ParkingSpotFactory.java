package com.example.shop.demo.ParkingLotApplication;

import java.util.Random;

public class ParkingSpotFactory {

    public static ParkingSpot getParkingSpotInstance(Vehicle v){
        Random random = new Random();

        if(v.getVehicleType().equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingSpot(random.nextInt(), v, SpotType.TWO_WHEELER);
        } else if(v.getVehicleType().equals(VehicleType.FOUR_WHEELER)){
            return new FourWheelerParkingSpot(random.nextInt(), v, SpotType.FOUR_WHEELER);
        } else
            return null;
    }
}
