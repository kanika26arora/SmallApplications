package com.example.shop.demo.robot;

import org.springframework.beans.factory.annotation.Autowired;

public class Robot {

    private int x;
    private int y;

    private Direction direction;

    private final Room room;

    public Robot(int x, int y, Direction direction, Room room){

        if (x < 0 || x >= room.getWidth() || y < 0 || y >= room.getLength()) {
            throw new IllegalArgumentException("Initial position out of room bounds");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.room = room;
    }

    int[] getCurrentPosition(){
        return new int[]{this.x, this.y};
    }

    public Direction getDirection(){
        return this.direction;
    }

//    public int[] turn(String currDir){
//
//        if(currDir.equalsIgnoreCase("left")){
//
//            if(this.direction.equals(Direction.UP)){
//                this.direction = Direction.LEFT;
//            }
//
//            else if(this.direction.equals(Direction.LEFT)){
//                this.direction = Direction.DOWN;
//            }
//
//            else if(this.direction.equals(Direction.DOWN)){
//                this.direction = Direction.RIGHT;
//            }
//
//            else if(this.direction.equals(Direction.RIGHT)){
//                this.direction = Direction.UP;
//            }
//
//            System.out.println("ROBOT IS NOW FACING:" + this.direction.name());
//            return getCurrentPosition();
//
//        } else if (currDir.equalsIgnoreCase("right")) {
//
//            if(this.direction.equals(Direction.UP)){
//                this.direction = Direction.RIGHT;
//            }
//
//            else if(this.direction.equals(Direction.RIGHT)){
//                this.direction = Direction.DOWN;
//            }
//
//            else if(this.direction.equals(Direction.DOWN)){
//                this.direction = Direction.LEFT;
//            }
//
//            else if(this.direction.equals(Direction.LEFT)){
//                this.direction = Direction.UP;
//            }
//
//            System.out.println("ROBOT IS NOW FACING:" + this.direction.name());
//            return getCurrentPosition();
//
//        } else{
//            throw new IllegalArgumentException("Not a valid turn");
//        }
//    }

//    public int[] move(int steps){
//
//            if(this.direction.equals(Direction.LEFT)) {
//                if (this.x - steps >= 0) {
//                    this.x = this.x - steps;
//                } else {
//                    throw new IllegalArgumentException("CANNOT MOVE HERE");
//                }
//            }
//
//            else if(this.direction.equals(Direction.UP)) {
//                if (this.y - steps >= 0) {
//                    this.y = this.y - steps;
//                } else {
//                    throw new IllegalArgumentException("CANNOT MOVE HERE");
//                }
//            }
//
//            else if(this.direction.equals(Direction.RIGHT)) {
//                if (this.x + steps < room.getWidth()) {
//                    this.x = x + steps;
//                } else {
//                    throw new IllegalArgumentException("CANNOT MOVE HERE");
//                }
//            }
//
//            else if(this.direction.equals(Direction.DOWN)){
//                if(this.y+steps < room.getLength() ){
//                    this.y = y + steps;
//                }
//                else{
//                    throw new IllegalArgumentException("CANNOT MOVE HERE");
//                }
//            }
//
//        System.out.println("ROBOT IS NOW AT " + this.x + " " + this.y);
//        return getCurrentPosition();
//
//    }

    public int[] turn(String currDir){

        int dirOrdinal = this.direction.ordinal();

        if(currDir.equalsIgnoreCase("left")){
            dirOrdinal = (dirOrdinal + 1) % 4;

        } else if (currDir.equalsIgnoreCase("right")) {
            dirOrdinal = (dirOrdinal + 3) % 4;

        } else{
            throw new IllegalArgumentException("Not a valid turn");
        }
        this.direction = Direction.values()[dirOrdinal];
        System.out.println("ROBOT IS NOW FACING:" + this.direction.name());
        return getCurrentPosition();
    }

    public int[] move(int steps){
        int newX = this.x;
        int newY = this.y;

        switch (this.direction) {
            case LEFT:
                newX -= steps;
                break;
            case UP:
                newY -= steps;
                break;
            case RIGHT:
                newX += steps;
                break;
            case DOWN:
                newY += steps;
                break;
        }

        if (newX < 0 || newX >= room.getWidth() || newY < 0 || newY >= room.getLength()) {
            throw new IllegalArgumentException("CANNOT MOVE HERE");
        }

        this.x = newX;
        this.y = newY;
        System.out.println("ROBOT IS NOW AT " + this.x + " " + this.y);
        return getCurrentPosition();
    }



}
