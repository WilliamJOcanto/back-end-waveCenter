package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private LocalDate date;
    private double ticketPrice;

    @ElementCollection
    @Column(name = "eventImages")
    private List<String> eventImages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Stand> stands = new ArrayList<>();

    public Event() {
    }

    public Event(String name, String description, LocalDate date, double ticketPrice, List<String> eventImages) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.eventImages = eventImages;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<String> getEventImages() {
        return eventImages;
    }

    public void setEventImages(List<String> eventImages) {
        this.eventImages = eventImages;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Stand> getStands() {
        return stands;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
        ticket.setEvent(this);
    }

    public void addStand(Stand stand){
        this.stands.add(stand);
        stand.setEvent(this);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", ticketPrice=" + ticketPrice +
                ", eventImages=" + eventImages +
                ", tickets=" + tickets +
                ", stands=" + stands +
                '}';
    }
}
