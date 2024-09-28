package com.mindHub.waveCenter.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class EventDTO {
    private String name;

    private LocalDateTime date;

    private String description;

    private double TicketPrice;

    private TypeGenre typeGender;

    private List<String> images;
}
