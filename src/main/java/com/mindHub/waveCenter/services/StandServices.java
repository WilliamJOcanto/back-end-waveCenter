package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.RentStandApliDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface StandServices {

    ResponseEntity<?> rentStand(RentStandApliDTO rentStandApliDTO, Authentication authentication);
}
