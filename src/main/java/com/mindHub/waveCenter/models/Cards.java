package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cardHolder;
    private int cvv;
    private String number;
    private LocalDate thruDate;
    private CardType cardType;
    private PaymentNetwork paymentNetwork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client owner;



    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
