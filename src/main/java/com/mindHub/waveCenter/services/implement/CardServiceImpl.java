package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.AddCardDTO;
import com.mindHub.waveCenter.DTO.CardDTO;
import com.mindHub.waveCenter.models.CardType;
import com.mindHub.waveCenter.models.Cards;
import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.PaymentNetwork;
import com.mindHub.waveCenter.repositories.CardRepository;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class CardServiceImpl implements CardServices {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Boolean textFieldValidator(String text) {
        return text.isBlank();
    }

    @Override
    public Boolean cvvFieldValidator(Integer cvv) {
        return cvv == null || cvv < 100;
    }

    @Override
    public Boolean thruDateFieldValidator(LocalDate thruDate) {
        return thruDate == null;
    }

    @Override
    public Boolean isCardNumberExists(AddCardDTO addCardDTO, Client client) {
        return cardRepository.existsByNumberAndOwner(addCardDTO.number(), client);
    }

    @Override
    public Cards makeCard(AddCardDTO addCardDTO) {
        return new Cards(addCardDTO.cardHolder(), addCardDTO.cvv(), addCardDTO.number(), addCardDTO.thruDate(), CardType.valueOf(addCardDTO.cardType().toUpperCase()), PaymentNetwork.valueOf(addCardDTO.paymentNetwork().toUpperCase()));
    }

    @Override
    public void saveCardRepository(Cards card) {
        cardRepository.save(card);
    }

    @Override
    public ResponseEntity<?> requestValidator(AddCardDTO addCardDTO, Client client) {

        if(textFieldValidator(addCardDTO.cardHolder())){
            return new ResponseEntity<>("The card holder field must not be empty", HttpStatus.BAD_REQUEST);
        }
        if(textFieldValidator(addCardDTO.number())){
            return new ResponseEntity<>("The number field must not be empty", HttpStatus.BAD_REQUEST);
        }
        if(cvvFieldValidator(addCardDTO.cvv())){
            return new ResponseEntity<>("Please, enter a valid CVV number", HttpStatus.BAD_REQUEST);
        }
        if(thruDateFieldValidator(addCardDTO.thruDate())){
            return new ResponseEntity<>("The date field must not be empty.", HttpStatus.BAD_REQUEST);
        }
        if(textFieldValidator(addCardDTO.cardType())){
            return new ResponseEntity<>("The card type field must not be empty", HttpStatus.BAD_REQUEST);
        }
        if(textFieldValidator(addCardDTO.paymentNetwork())){
            return new ResponseEntity<>("The payment network field must not be empty", HttpStatus.BAD_REQUEST);
        }
        if(isCardNumberExists(addCardDTO, client)){
            return new ResponseEntity<>("The card already exists for this customer", HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> addingCard(AddCardDTO addCardDTO, Authentication authentication) {

        Client client = clientRepository.findByEmail(authentication.getName());

        ResponseEntity<?> validatorResponse = requestValidator(addCardDTO,client);
        if(validatorResponse != null){
            return validatorResponse;
        }

        Cards newCard = makeCard(addCardDTO);
        client.addCard(newCard);
        saveCardRepository(newCard);
        clientRepository.save(client);

        return new ResponseEntity<>(new CardDTO(newCard), HttpStatus.CREATED);
    }

    @Override
    public List<Cards> getAllCards() {
        return List.of();
    }

    @Override
    public List<CardDTO> getAllCardDto() {
        return List.of();
    }
}
