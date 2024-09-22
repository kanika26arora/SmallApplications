package com.example.shop.demo.ElevatorSystem;

public class ElevatorCar {

    InternalButton internalButton;
    Direction direction;
    int id;
    ElevatorStatus status;
    int currentFloor;

    ElevatorCar(int id, int currentFloor){
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.UP;
        this.status = ElevatorStatus.IDLE;
    }


    public void move(ElevatorCarController elevatorCarController){

        if(this.direction == Direction.UP){

            while (!elevatorCarController.minHeap.isEmpty()){
                elevatorCarController.minHeap.remove();
            }

            this.direction = Direction.DOWN;
            elevatorCarController.minHeap.addAll(elevatorCarController.pendingJobs);

        } else{

            while (!elevatorCarController.maxHeap.isEmpty()){
                elevatorCarController.maxHeap.remove();
            }

            this.direction = Direction.UP;
            elevatorCarController.maxHeap.addAll(elevatorCarController.pendingJobs);
        }
    }
}
