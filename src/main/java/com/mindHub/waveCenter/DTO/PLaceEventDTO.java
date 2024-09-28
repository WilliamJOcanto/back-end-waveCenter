package com.mindHub.waveCenter.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class PLaceEventDTO {

    private String name;

    private LocalDateTime date;

    private String description;

    private double TicketPrice;

    private TypeGenre typeGender;

    private List<String> images;

    public PLaceEventDTO(PlaceEvent placeEvent) {
        this.name = placeEvent.getEvent().getName();
        this.date = placeEvent.getEvent().getDate();
        this.description = placeEvent.getEvent().getDescription();
        this.TicketPrice = placeEvent.getEvent().getTicketPrice();
        this.typeGender = placeEvent.getEvent().getTypeGender();
        this.images = placeEvent.getEvent().getImages();

    }


    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getTicketPrice() {
        return TicketPrice;
    }

    public TypeGenre getTypeGender() {
        return typeGender;
    }

    public List<String> getImages() {
        return images;
    }
}
