package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceDTO {
    private long id;
    private String name;

    private int ticketMaxCapacity;

    private int standMaxCapacity;

    private String description;

    private List<EventDTO> events = new ArrayList<>();

    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.ticketMaxCapacity = place.getTicketMaxCapacity();
        this.standMaxCapacity = place.getStandMaxCapacity();
        this.description = place.getDescription();
        this.events = place.getEvents().stream().map(EventDTO::new).toList();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTicketMaxCapacity() {
        return ticketMaxCapacity;
    }

    public int getStandMaxCapacity() {
        return standMaxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public List<EventDTO> getEvents() {
        return events;
    }
}
