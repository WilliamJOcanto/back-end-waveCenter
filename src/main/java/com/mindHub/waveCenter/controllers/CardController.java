package com.mindHub.waveCenter.controllers;

import com.mindHub.waveCenter.DTO.AddCardDTO;
import com.mindHub.waveCenter.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardServices cardServices;

    @PostMapping("/current")
    ResponseEntity<?> addNewCardToClient(@RequestBody AddCardDTO addCardDTO, Authentication authentication){
        try{
            return cardServices.addingCard(addCardDTO, authentication);
        }catch (Exception e) {
            return new ResponseEntity<>("Error adding card: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
