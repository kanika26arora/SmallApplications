package com.example.shop.demo.ElevatorSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorCarController {

    ElevatorCar elevatorCar;

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    List<Integer> pendingJobs;

    ElevatorCarController(ElevatorCar elevatorCar, PriorityQueue<Integer> maxHeap,
                          PriorityQueue<Integer> minHeap, List<Integer> pendingJobs){

        this.elevatorCar = elevatorCar;
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
        this.pendingJobs = new ArrayList<>();
    }


    public void go(){

        elevatorCar.move(this);
    }





}
