package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.TicketAplicationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface TicketSercvices {

    ResponseEntity<?> buyTicket(Authentication authentication, TicketAplicationDTO ticketAplicationDTO);

    ResponseEntity<?> filters(TicketAplicationDTO ticketAplicationDTO);
}
