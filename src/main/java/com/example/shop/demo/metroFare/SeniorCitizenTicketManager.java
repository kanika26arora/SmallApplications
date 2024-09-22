package com.example.shop.demo.metroFare;

import java.util.List;

public class SeniorCitizenTicketManager extends TicketManager{

    @Override
    public double purchaseTicket(Line route, Ticket ticket) {

        double basePrice = super.calculateBasePrice(ticket.getFrom(), ticket.getTo(), route);
        boolean isSurge = super.isSurgeTime(ticket);
        if(isSurge){
            basePrice += (0.2 * basePrice);
        }
        return (basePrice/2);
    }
}
