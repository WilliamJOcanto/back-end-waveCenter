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

    public Cards() {
    }

    public Cards(String cardHolder, int cvv, String number, LocalDate thruDate, CardType cardType, PaymentNetwork paymentNetwork) {
        this.cardHolder = cardHolder;
        this.cvv = cvv;
        this.number = number;
        this.thruDate = thruDate;
        this.cardType = cardType;
        this.paymentNetwork = paymentNetwork;
    }

    public long getId() {
        return id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public PaymentNetwork getPaymentNetwork() {
        return paymentNetwork;
    }

    public void setPaymentNetwork(PaymentNetwork paymentNetwork) {
        this.paymentNetwork = paymentNetwork;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", cardHolder='" + cardHolder + '\'' +
                ", cvv=" + cvv +
                ", number='" + number + '\'' +
                ", thruDate=" + thruDate +
                ", cardType=" + cardType +
                ", paymentNetwork=" + paymentNetwork +
                '}';
    }
}
