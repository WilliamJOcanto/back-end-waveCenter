package com.mindHub.waveCenter.DTO;

import java.time.LocalDateTime;

public class TicketDTO {

    private long id;

    private LocalDateTime purchaseDate;

    private double priecePaid;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.purchaseDate = ticket.getPurchaseDate();
        this.priecePaid = ticket.getPriecePaid();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public double getPriecePaid() {
        return priecePaid;
    }
}
