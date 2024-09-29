package com.mindHub.waveCenter.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDTO {
    private long id;
    private LocalDate purchaseDate;

    private  int quantity;

    private String hashCode;

    private List<OrderTicketDTO> orders = new ArrayList<>();

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.purchaseDate = ticket.getPurchaseDate();
        this.quantity = ticket.getQuantity();
        this.hashCode = ticket.getHashCode();
        this.orders = ticket.getOrders().stream().map(OrderTicketDTO::new).toList();
    }

    public long getId() {
        return id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getHashCode() {
        return hashCode;
    }

    public List<OrderTicketDTO> getOrders() {
        return orders;
    }
}
