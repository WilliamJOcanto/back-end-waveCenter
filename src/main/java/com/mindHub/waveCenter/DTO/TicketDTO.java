package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Ticket;

import java.time.LocalDateTime;

public class TicketDTO {
    private long id;
    private String eventName;
    private LocalDateTime purchaseDate;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.eventName = ticket.getEventName();
        this.purchaseDate = ticket.getPurchaseDate();
    }

    public long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
}
