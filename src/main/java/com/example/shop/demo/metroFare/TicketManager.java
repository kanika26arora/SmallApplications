package com.example.shop.demo.metroFare;

import org.springframework.util.RouteMatcher;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public abstract class TicketManager {

    int calculateBasePrice(Station from, Station to, Line route){

        int distance = (route.stationMap.get(to.name) -  route.stationMap.get(from.name));

        return (distance*10);
    }

    public abstract double purchaseTicket(Line route, Ticket ticket);

    boolean isSurgeTime(Ticket ticket){

        if ((ticket.purchaseTime.isAfter(LocalTime.parse("17:00:00")) &&
                ticket.purchaseTime.isBefore(LocalTime.parse("20:00:00")))){
            return true;
        }
        return false;
    }
}
