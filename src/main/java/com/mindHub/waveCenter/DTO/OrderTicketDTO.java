package com.mindHub.waveCenter.DTO;

import java.time.LocalDate;

public class OrderTicketDTO {

    private long id;

    private LocalDate purchaseDate;
    private String name;
    private int quantity;
    private double price;

    public OrderTicketDTO(OrderTicket orderTicket) {
        this.id = orderTicket.getId();
        this.purchaseDate = orderTicket.getPurchaseDate();
        this.name = orderTicket.getName();
        this.quantity = orderTicket.getQuantity();
        this.price = orderTicket.getPrice();
    }

    public long getId() {
        return id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

}
