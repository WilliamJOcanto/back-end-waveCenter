package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
