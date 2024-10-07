package com.mindHub.waveCenter.services;

import com.mindHub.waveCenter.DTO.AddCardDTO;
import com.mindHub.waveCenter.DTO.CardDTO;
import com.mindHub.waveCenter.models.Cards;
import com.mindHub.waveCenter.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.List;

public interface CardServices {

    Boolean textFieldValidator(String text);
    Boolean cvvFieldValidator(Integer cvv);
    Boolean thruDateFieldValidator(LocalDate thruDate);
    Boolean isCardNumberExists(AddCardDTO addCardDTO, Client client);
    Cards makeCard(AddCardDTO addCardDTO);
    void saveCardRepository(Cards card);
    ResponseEntity<?> requestValidator(AddCardDTO addCardDTO, Client client);
    ResponseEntity<?> addingCard(AddCardDTO addCardDTO, Authentication authentication);
    List<Cards> getAllCards();
    List<CardDTO> getAllCardDto();

}
