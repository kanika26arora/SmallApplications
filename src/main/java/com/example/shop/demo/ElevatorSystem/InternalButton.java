package com.example.shop.demo.ElevatorSystem;

public class InternalButton {

    ElevatorCarController elevatorCarController;

    public void press(Floor floor){

        if(floor.level > elevatorCarController.elevatorCar.currentFloor &&
                elevatorCarController.elevatorCar.direction == Direction.UP){
            elevatorCarController.minHeap.add(floor.level);
        } else if(
                floor.level < elevatorCarController.elevatorCar.currentFloor &&
                        elevatorCarController.elevatorCar.direction == Direction.DOWN) {
            elevatorCarController.maxHeap.add(floor.level);
        }
        else{
            elevatorCarController.pendingJobs.add(floor.level);
        }
    }
}
