package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.DTO.CreateEventDTO;
import com.mindHub.waveCenter.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventServices eventServices;
    @GetMapping("/all")
    public ResponseEntity<?> getEvents(Authentication authentication) {
        return eventServices.getAllEvents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id){
        return eventServices.getEventDtoById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createNewEvent(@RequestBody CreateEventDTO createEventDTO, Authentication authentication){

        try{
            return eventServices.makeNewEvent(createEventDTO);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error creating event" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
