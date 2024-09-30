package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<OrderTicketDTO> orderTickets = new ArrayList<>();
    private List<RentStandDTO> rents = new ArrayList<>();
    private List<CardDTO> cards = new ArrayList<>();

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.orderTickets = client.getOrderTickets().stream().map(OrderTicketDTO::new).toList();
        this.rents = client.getRentStand().stream().map(RentStandDTO::new).toList();
        this.cards = client.getCards().stream().map(CardDTO::new).toList();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<OrderTicketDTO> getOrderTickets() {
        return orderTickets;
    }

    public List<RentStandDTO> getRents() {
        return rents;
    }

    public List<CardDTO> getCards() {
        return cards;
    }
}
