package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.EventDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventServices {
    ResponseEntity<?> getAllEvents();
}
