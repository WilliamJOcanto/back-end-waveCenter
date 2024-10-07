package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.RentStand;
import com.mindHub.waveCenter.models.Stand;
import com.mindHub.waveCenter.models.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentStandDTO {
    private long id;
    private String name;
    private String description;
    private String hashCode;
    private List<Integer> rentedPositions;

    private LocalDateTime renDate;

    private StandDTO standDTO;

    private String eventName;

    private LocalDateTime date;

    public RentStandDTO(RentStand rentStand) {
        this.id = rentStand.getId();
        this.name = rentStand.getName();
        this.description = rentStand.getDescription();
        this.hashCode = rentStand.getHashCode();
        this.rentedPositions = rentStand.getRentedPositions();
        this.renDate = rentStand.getRentDate();
        this.eventName = rentStand.getStand().getEvent().getName();
        this.date = rentStand.getStand().getEvent().getTickets().stream()
                .map(Ticket::getPurchaseDate)
                .findFirst()
                .orElse(null);
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

    public String getHashCode() {
        return hashCode;
    }

    public List<Integer> getRentedPositions() {
        return rentedPositions;
    }

    public LocalDateTime getRenDate() {
        return renDate;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
