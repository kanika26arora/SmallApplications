package com.example.shop.demo.metroFare;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket {

    private int price;
    private Station from;
    private Station to;

    private TicketType type;

    LocalTime purchaseTime;

    public TicketType getType() {
        return type;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public Ticket(Station from, Station to, TicketType ticketType, LocalTime purchaseTime){
        this.from = from;
        this.to = to;
        this.type = ticketType;
        this.purchaseTime = purchaseTime;
    }

}
