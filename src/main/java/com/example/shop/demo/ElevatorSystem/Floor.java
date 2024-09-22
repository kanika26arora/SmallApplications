package com.example.shop.demo.ElevatorSystem;

public class Floor {

    int level;
    ExternalButton externalButton;

    Floor(int level, ExternalButton externalButton){
        this.level = level;
        this.externalButton = externalButton;
    }
}
