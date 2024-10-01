package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.services.StandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stand")
public class StandController {
    @Autowired
    StandServices standServices;

    @RequestMapping("/apply")
    public ResponseEntity<?> apply() {
        return standServices.rentStand();
    }

}
