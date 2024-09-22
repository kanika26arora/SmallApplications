package com.example.shop.demo;

import com.example.shop.demo.robot.Direction;
import com.example.shop.demo.robot.Robot;
import com.example.shop.demo.robot.Room;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RobotTestApplication {

    @Test
    public void simpleTest(){

        Room room = new Room(3, 4);
        Robot robot = new Robot(0, 0, Direction.valueOf("up".toUpperCase()), room);

        robot.turn("left");
        assertEquals(Direction.LEFT, robot.getDirection());

        assertThrows(IllegalArgumentException.class, () ->
                robot.move(2));


    }

    @Test
    public void simpleTest2(){

        Room room = new Room(3, 4);
        Robot robot = new Robot(0, 0, Direction.valueOf("up".toUpperCase()), room);

        robot.turn("right");
        assertEquals(Direction.RIGHT, robot.getDirection());

        int[] move = robot.move(2);
        assertEquals(2, move[0]);
        assertEquals(0, move[1]);


    }
}
