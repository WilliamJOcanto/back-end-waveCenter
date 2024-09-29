package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.CardType;
import com.mindHub.waveCenter.models.Cards;
import com.mindHub.waveCenter.models.PaymentNetwork;

import java.time.LocalDate;

public class CardDTO {
    private long id;

    private  String holderName;

    private  String number;

    private  int cvv;

    private LocalDate thruDate;

    private CardType type;

    private PaymentNetwork networkType;

    public CardDTO(Cards card) {
        this.id = card.getId();
        this.holderName = card.getHolderName();
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.thruDate = card.getThruDate();
        this.type = card.getType();
        this.networkType = card.getNetworkType();
    }

    public long getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getThruDate() {
        return thruDate;
    }

    public CardType getType() {
        return type;
    }

    public PaymentNetworkType getNetworkType() {
        return networkType;
    }
}
