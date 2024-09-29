package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class OrderTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime purchaseDate;
    private int quantity;
    private String hashCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client owner;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public OrderTicket() {
    }

    public OrderTicket(LocalDateTime purchaseDate, int quantity, String hashCode) {
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.hashCode = hashCode;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
