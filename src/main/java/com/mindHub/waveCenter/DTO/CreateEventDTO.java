package com.mindHub.waveCenter.DTO;

import java.time.LocalDate;
import java.util.List;

public record CreateEventDTO(String name, String description, List<String> artists, LocalDate date, Double ticketPrice, List<String> images, Long placeId) {
}
