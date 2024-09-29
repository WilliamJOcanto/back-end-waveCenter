package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<OrderTicket> orderTickets;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<RentStand> rentStand;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Cards> cards;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }



    public void addOrderTicket(OrderTicket orderTicket){
        this.orderTickets.add(orderTicket);
        orderTicket.setOwner(this);
    }

    public void addRentStand(RentStand rentStand){
        this.rentStand.add(rentStand);
        rentStand.setOwner(this);
    }

    public void addCard(Cards cards){
        this.cards.add(cards);
        cards.setOwner(this);
    }


}
