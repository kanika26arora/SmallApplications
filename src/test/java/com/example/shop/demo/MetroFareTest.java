package com.example.shop.demo;

import com.example.shop.demo.metroFare.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MetroFareTest {

    @Test
    public void test1(){

        Station downtown = new Station(0, "DownTown");
        Station markham = new Station(1, "markham");
        Station brampton = new Station(2, "brampton");
        Station missisauga = new Station(3, "missisauga");
        Station ottawa = new Station(4, "ottawa");

        List<Station> stationList = new ArrayList<>();
        stationList.add(downtown);
        stationList.add(markham);
        stationList.add(brampton);
        stationList.add(missisauga);
        stationList.add(ottawa);

        Line red = new Line(0, stationList);

        Ticket ticket1 = new Ticket(downtown, ottawa, TicketType.Regular, LocalTime.now());
        Ticket ticket2 = new Ticket(markham, ottawa, TicketType.Senior_Citizen, LocalTime.now());
        Ticket ticket3 = new Ticket(downtown, ottawa, TicketType.Student, LocalTime.now());

        double price1 = TicketManagerFactory.getTicketManagerInstance(ticket1).
                purchaseTicket(red, ticket1);
        assertEquals(48, price1);

        double price2 = TicketManagerFactory.getTicketManagerInstance(ticket2).
                purchaseTicket(red, ticket2);
        assertEquals(18, price2);

        double price3 = TicketManagerFactory.getTicketManagerInstance(ticket3).
                purchaseTicket(red, ticket3);
        assertEquals(12, price3);




    }
}
