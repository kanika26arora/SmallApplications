package com.example.shop.demo.ParkingLotApplication;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... s) throws InterruptedException {

        List<ParkingSpot> two_wheeler = new ArrayList<>();
        List<ParkingSpot> four_wheeler = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle(1, VehicleType.TWO_WHEELER);

        System.out.println("Vehicle has arrived: " + vehicle1.getNumber());

        ParkingLotManager parkingLotManager = ParkingLotManagerFactory.getInstance(vehicle1.getVehicleType(),
                two_wheeler);

        System.out.println("Finding space for " + vehicle1.getNumber());

        ParkingSpot parkingSpot = parkingLotManager.findParkingSpace(vehicle1);

        System.out.println("Found space for: " + vehicle1.getNumber() + " at " + parkingSpot.id);
        System.out.println("Parking vehicle: " + vehicle1.getNumber());

        parkingLotManager.parkVehicle(vehicle1, parkingSpot);

        System.out.println("Issuing ticket... ");

        Ticket t = parkingLotManager.issueTicket(parkingSpot, vehicle1);

        Thread.sleep(5000);

        System.out.println("Calculating parking fee ");

        long parkingFee = parkingLotManager.calculateFee(t);

        System.out.println("Fee is: " + parkingFee);

        parkingLotManager.freeParkingSpot(parkingSpot);

        System.out.println("Vehicle removed " + two_wheeler.size());




        Vehicle vehicle2 = new Vehicle(2, VehicleType.TWO_WHEELER);

        System.out.println("Vehicle has arrived: " + vehicle2.getNumber());

        ParkingLotManager parkingLotManager2 = ParkingLotManagerFactory.getInstance(vehicle2.getVehicleType(),
                two_wheeler);

        System.out.println("Finding space for " + vehicle2.getNumber());

        ParkingSpot parkingSpot2 = parkingLotManager2.findParkingSpace(vehicle2);

        System.out.println("Found space for: " + vehicle2.getNumber() + " at " + parkingSpot2.id);
        System.out.println("Parking vehicle: " + vehicle2.getNumber());

        parkingLotManager2.parkVehicle(vehicle2, parkingSpot2);

        System.out.println("Issuing ticket... ");

        Ticket t2 = parkingLotManager2.issueTicket(parkingSpot2, vehicle2);

        Thread.sleep(5000);

        System.out.println("Calculating parking fee ");

        long parkingFee2 = parkingLotManager.calculateFee(t2);

        System.out.println("Fee is: " + parkingFee2);

        parkingLotManager2.freeParkingSpot(parkingSpot2);

        System.out.println("Vehicle removed " + two_wheeler.size());




        Vehicle vehicle3 = new Vehicle(3, VehicleType.FOUR_WHEELER);

        System.out.println("Vehicle has arrived: " + vehicle3.getNumber());

        ParkingLotManager parkingLotManager3 = ParkingLotManagerFactory.getInstance(vehicle3.getVehicleType(),
                four_wheeler);

        System.out.println("Finding space for " + vehicle3.getNumber());

        ParkingSpot parkingSpot3 = parkingLotManager2.findParkingSpace(vehicle3);

        System.out.println("Found space for: " + vehicle3.getNumber() + " at " + parkingSpot3.id);
        System.out.println("Parking vehicle: " + vehicle3.getNumber());

        parkingLotManager2.parkVehicle(vehicle3, parkingSpot3);

        System.out.println("Issuing ticket... ");

        Ticket t3 = parkingLotManager3.issueTicket(parkingSpot3, vehicle3);

        Thread.sleep(5000);

        System.out.println("Calculating parking fee ");

        long parkingFee3 = parkingLotManager.calculateFee(t3);

        System.out.println("Fee is: " + parkingFee3);

        parkingLotManager3.freeParkingSpot(parkingSpot3);

        System.out.println("Vehicle removed " + four_wheeler.size());
        }
}
