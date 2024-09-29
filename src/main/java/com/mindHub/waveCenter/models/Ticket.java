package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime purchaseDate;
    private String sector;
    private double pricePaid;


    public Ticket() {
    }

    public Ticket(LocalDateTime purchaseDate, String sector, double pricePaid) {
        this.purchaseDate = purchaseDate;
        this.sector = sector;
        this.pricePaid = pricePaid;
    }


}
