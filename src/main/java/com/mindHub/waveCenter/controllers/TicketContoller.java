package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.DTO.TicketAplicationDTO;
import com.mindHub.waveCenter.services.TicketSercvices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketContoller {

    @Autowired
    private TicketSercvices ticketSercvices;
    @PostMapping("/apply")
    public ResponseEntity<?> getOrderTicket(Authentication authentication, @RequestBody TicketAplicationDTO ticketAplicationDTO) {
        return ticketSercvices.buyTicket(authentication,ticketAplicationDTO);
    }
}
