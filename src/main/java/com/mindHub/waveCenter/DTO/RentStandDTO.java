package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.RentStand;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentStandDTO {
    private long id;
    private String name;
    private String description;
    private String hashCode;
    private List<Integer> rentedPositions;

    private LocalDateTime renDate;

    private StandDTO standDTO;

    private String eventName;

    public RentStandDTO(RentStand rentStand) {
        this.id = rentStand.getId();
        this.name = rentStand.getName();
        this.description = rentStand.getDescription();
        this.hashCode = rentStand.getHashCode();
        this.rentedPositions = rentStand.getRentedPositions();
        this.renDate = rentStand.getRentDate();
        this.eventName = rentStand.getStand().getEvent().getName();
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
}
