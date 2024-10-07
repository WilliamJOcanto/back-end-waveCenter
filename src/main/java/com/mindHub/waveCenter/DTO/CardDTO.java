package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.CardType;
import com.mindHub.waveCenter.models.Cards;
import com.mindHub.waveCenter.models.PaymentNetwork;

import java.time.LocalDate;

public class CardDTO {
    private long id;

    private  String CardHolder;

    private  int cvv;

    private  String number;

    private LocalDate thruDate;

    private CardType type;

    private PaymentNetwork networkType;

    public CardDTO(Cards card) {
        this.id = card.getId();
        this.CardHolder = card.getCardHolder();
        this.cvv = card.getCvv();
        this.number = card.getNumber();
        this.thruDate = card.getThruDate();
        this.type = card.getCardType();
        this.networkType = card.getPaymentNetwork();
    }

    public long getId() {
        return id;
    }

    public String getCardHolder() {
        return CardHolder;
    }

    public int getCvv() {
        return cvv;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public CardType getType() {
        return type;
    }

    public PaymentNetwork getNetworkType() {
        return networkType;
    }
}
