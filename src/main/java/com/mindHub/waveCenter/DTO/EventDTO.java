package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Event;
import com.mindHub.waveCenter.models.OrderTicket;
import com.mindHub.waveCenter.models.RentStand;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private long id;
    private String name;
    private String description;
    private LocalDate date;
    private double ticketPrice;
    private PlaceDTO place;

    private List<String> images = new ArrayList<>();
    private List<StandDTO> stands = new ArrayList<>();
    private List<TicketDTO> tickets = new ArrayList<>();

    private List<String> artists = new ArrayList<>();

    private int ticketsAvailable;

    private int standAvailable;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.date = event.getDate();
        this.ticketPrice = event.getTicketPrice();
        this.place = new PlaceDTO(event.getPlace()); // Convertir Place a PlaceDTO
        this.images = event.getEventImages();
        this.stands = event.getStands().stream().map(StandDTO::new).toList();
        this.tickets = event.getTickets().stream().map(TicketDTO::new).toList();
        this.artists = event.getArtists();
        this.ticketsAvailable = event.getPlace().getTicketMaxCapacity() - event.getTickets()
                .stream()
                .flatMap(t -> t.getOrderTickets().stream())
                .mapToInt(OrderTicket::getQuantity)
                .sum();
        this.standAvailable = event.getPlace().getTicketMaxCapacity() - event.getStands()
                .stream()
                .flatMap(t -> t.getRentStands().stream())
                .mapToInt(rentStand -> rentStand.getRentedPositions().size()) // Contamos las posiciones alquiladas
                .sum();
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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public List<String> getImages() {
        return images;
    }

    public List<StandDTO> getStands() {
        return stands;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public List<String> getArtists() {
        return artists;
    }

    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public int getStandAvailable() {return standAvailable;}
}
