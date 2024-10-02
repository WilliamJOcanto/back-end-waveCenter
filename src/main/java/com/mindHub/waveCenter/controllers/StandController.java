package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.DTO.RentStandApliDTO;
import com.mindHub.waveCenter.services.StandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stand")
public class StandController {
    @Autowired
    StandServices standServices;

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody RentStandApliDTO rentStandApliDTO, Authentication authentication) {
        return standServices.rentStand(rentStandApliDTO, authentication);
    }

}
