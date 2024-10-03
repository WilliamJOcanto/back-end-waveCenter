package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.CreateEventDTO;
import com.mindHub.waveCenter.DTO.EventDTO;
import com.mindHub.waveCenter.models.Event;
import com.mindHub.waveCenter.models.Place;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventServices {
    ResponseEntity<?> getAllEvents();
    Event eventById(Long id);
    ResponseEntity<?> getEventDtoById(Long id);
    Place getPlaceById(Long id);
    ResponseEntity<?> makeNewEvent(CreateEventDTO createEventDTO);
}
