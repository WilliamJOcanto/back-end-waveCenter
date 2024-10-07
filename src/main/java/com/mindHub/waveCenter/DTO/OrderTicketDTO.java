package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.OrderTicket;
import com.mindHub.waveCenter.models.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderTicketDTO {

    private long id;
    private LocalDateTime purchaseDate;
    private int quantity;

    private String hashCode;

    private String event;

    private long eventId;

    private List<Integer> positions = new ArrayList<>();

    public OrderTicketDTO(OrderTicket orderTicket) {
        this.id = orderTicket.getId();
        this.purchaseDate = orderTicket.getPurchaseDate();
        this.quantity = orderTicket.getQuantity();
        this.hashCode = orderTicket.getHashCode();
        this.event = orderTicket.getTicket().getEventName();
        this.eventId = orderTicket.getTicket().getEvent().getId();
        this.positions = orderTicket.getPositions();
    }

    public long getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getHashCode() {
        return hashCode;
    }

    public long getEventId() {
        return eventId;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
