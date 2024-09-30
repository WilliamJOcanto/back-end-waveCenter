package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    private List<OrderTicket> orderTickets = new ArrayList<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<RentStand> rentStand = new ArrayList<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Cards> cards = new ArrayList<>();

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderTicket> getOrderTickets() {
        return orderTickets;
    }

    public List<RentStand> getRentStand() {
        return rentStand;
    }

    public List<Cards> getCards() {
        return cards;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orderTickets=" + orderTickets +
                ", rentStand=" + rentStand +
                ", cards=" + cards +
                '}';
    }
}
