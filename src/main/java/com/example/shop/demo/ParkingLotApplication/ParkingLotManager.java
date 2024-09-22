package com.example.shop.demo.ParkingLotApplication;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class ParkingLotManager {

    List<ParkingSpot> parkingSpotList;

    ParkingLotManager(List<ParkingSpot> parkingSpotList){
        this.parkingSpotList = parkingSpotList;
    }

    ParkingSpot findParkingSpace(Vehicle v){

        ParkingSpot parkingSpot = ParkingSpotFactory.getParkingSpotInstance(v);
        parkingSpotList.add(parkingSpot);
        return parkingSpot;
    }

    void parkVehicle(Vehicle v, ParkingSpot s){
            s.setVehicle(v);
    }

    Ticket issueTicket(ParkingSpot parkingSpot, Vehicle v){

        return new Ticket(Instant.now(), parkingSpot, v);

    }

    long calculateFee(Ticket ticket){
        long seconds = ChronoUnit.SECONDS.between(ticket.getEntryTime(), Instant.now());
        return (seconds*ticket.getParkingSpot().price);
    }

    void freeParkingSpot(ParkingSpot parkingSpot){

        parkingSpot.isFree = true;
        parkingSpot.setVehicle(null);
        parkingSpotList.remove(parkingSpot);

    }
}
