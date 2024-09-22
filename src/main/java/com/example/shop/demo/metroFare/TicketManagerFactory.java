package com.example.shop.demo.metroFare;

public class TicketManagerFactory {

    public static TicketManager getTicketManagerInstance(Ticket ticket){
        if(ticket.getType().equals(TicketType.Regular)){
            return new RegularTicketManager();
        } else if (ticket.getType().equals(TicketType.Student)) {
            return new StudentTicketManager();
        } else if (ticket.getType().equals(TicketType.Senior_Citizen)) {
            return new SeniorCitizenTicketManager();
        } else{
            throw new IllegalArgumentException("Ticket type not valid");
        }
    }
}
