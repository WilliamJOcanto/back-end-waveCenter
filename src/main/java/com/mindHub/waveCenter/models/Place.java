package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int ticketMaxCapacity;
    private int standMaxCapacity;
    private String description;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private List<Event> events;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public Place() {
    }

    public Place(String name, int ticketMaxCapacity, int standMaxCapacity, String description) {
        this.name = name;
        this.ticketMaxCapacity = ticketMaxCapacity;
        this.standMaxCapacity = standMaxCapacity;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketMaxCapacity() {
        return ticketMaxCapacity;
    }

    public void setTicketMaxCapacity(int ticketMaxCapacity) {
        this.ticketMaxCapacity = ticketMaxCapacity;
    }

    public int getStandMaxCapacity() {
        return standMaxCapacity;
    }

    public void setStandMaxCapacity(int standMaxCapacity) {
        this.standMaxCapacity = standMaxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addEvent(Event event){
        this.events.add(event);
        event.setPlace(this);
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
        ticket.setPlace(this);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticketMaxCapacity=" + ticketMaxCapacity +
                ", standMaxCapacity=" + standMaxCapacity +
                ", description='" + description + '\'' +
                ", events=" + events +
                ", tickets=" + tickets +
                '}';
    }
}
