package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.RentStandApliDTO;
import com.mindHub.waveCenter.models.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface StandServices {
    String requestValidator(RentStandApliDTO rentStandApliDTO, Event event);
    ResponseEntity<?> rentStand(RentStandApliDTO rentStandApliDTO, Authentication authentication);
}
