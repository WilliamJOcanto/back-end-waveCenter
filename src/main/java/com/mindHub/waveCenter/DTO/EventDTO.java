package com.mindHub.waveCenter.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDTO {

    private long id;
    private String name;
    private String description;

    private LocalDate date;
    private double ticketsPrice;

    private List<StandDTO> stands = new ArrayList<>();

    private List<TicketDTO> tickets = new ArrayList<>();

    private List<String> images = new ArrayList<>();


    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.date = event.getDate();
        this.ticketsPrice = event.getTicketsPrice();
        this.stands = event.getStands();
        this.tickets = event.getTickets();
        this.images = event.getImages();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTicketsPrice() {
        return ticketsPrice;
    }

    public List<StandDTO> getStands() {
        return stands;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public List<String> getImages() {
        return images;
    }
}
