package com.mindHub.waveCenter.DTO;

import java.util.List;

public class PlaceDTO {
    private long id;
    private String name;

    private List<userStand> stands;

    private List<EventDTO> events;



    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.stands = place.getStands().stream().map(StanDTO::new).collect(Collectors.toList());
        this.events = place.getEvents().stream().map(EventDTO::new).collect(Collectors.toList());
    }
}
