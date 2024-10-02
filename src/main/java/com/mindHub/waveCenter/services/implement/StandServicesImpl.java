package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.RentStandApliDTO;
import com.mindHub.waveCenter.DTO.RentStandDTO;
import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.Event;
import com.mindHub.waveCenter.models.RentStand;
import com.mindHub.waveCenter.models.Stand;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.repositories.EventRepository;
import com.mindHub.waveCenter.repositories.RentStandRepository;
import com.mindHub.waveCenter.repositories.StandRepository;
import com.mindHub.waveCenter.services.StandServices;
import com.mindHub.waveCenter.utils.GenerateHasCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StandServicesImpl implements StandServices {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GenerateHasCode generateHasCode;

    @Autowired
    private RentStandRepository rentStandRepository;

    @Autowired
    private StandRepository standRepository;

    @Override
    public ResponseEntity<?> rentStand(RentStandApliDTO rentStandApliDTO, Authentication authentication) {



        Client client = clientRepository.findByEmail(authentication.getName());
        Event event = eventRepository.findById(rentStandApliDTO.enventId());
        List<Stand> stands = event.getStands().stream()
                .filter(stand -> stand.getLocations().stream().anyMatch(location -> rentStandApliDTO.positions().contains(location)))
                .toList();

        if(stands.size() == 1){
            Stand stand = stands.get(0);
            stand.getLocations().removeAll(rentStandApliDTO.positions());
            RentStand rentStand = new RentStand(rentStandApliDTO.name(), rentStandApliDTO.description(), generateHasCode.generateHashCodeRentStand(), rentStandApliDTO.positions(), LocalDateTime.now());
            stand.addRentStand(rentStand);
            client.addRentStand(rentStand);
            rentStandRepository.save(rentStand);
            standRepository.save(stand);
            clientRepository.save(client);

            return new ResponseEntity<>(new RentStandDTO(rentStand), HttpStatus.OK);
        }else{
            List<Integer> positionsSmall = rentStandApliDTO.positions().stream().filter(integer -> integer >= 11 && integer <=20).toList();
            RentStand rentStandSmall = new RentStand(rentStandApliDTO.name(), rentStandApliDTO.description(), generateHasCode.generateHashCodeRentStand(), positionsSmall, LocalDateTime.now());

            List<Integer> positionsBig = rentStandApliDTO.positions().stream().filter(integer -> integer >= 1 && integer <=10).toList();
            RentStand rentStandBig = new RentStand(rentStandApliDTO.name(), rentStandApliDTO.description(), generateHasCode.generateHashCodeRentStand(), positionsBig, LocalDateTime.now());

            Stand smallStand = stands.stream()
                    .filter(stand -> stand.getSize().equals("small"))
                    .findFirst()
                    .orElse(null);

            smallStand.getLocations().removeAll(positionsSmall);
            smallStand.addRentStand(rentStandSmall);
            rentStandRepository.save(rentStandSmall);
            standRepository.save(smallStand);

            Stand bigStand = stands.stream()
                    .filter(stand -> stand.getSize().equals("big"))
                    .findFirst()
                    .orElse(null);

            bigStand.getLocations().removeAll(positionsBig);
            bigStand.addRentStand(rentStandBig);
            rentStandRepository.save(rentStandBig);
            standRepository.save(bigStand);

            RentStand rentStandClient = new RentStand(rentStandApliDTO.name(), rentStandApliDTO.description(), generateHasCode.generateHashCodeRentStand(), rentStandApliDTO.positions(),LocalDateTime.now());
            client.addRentStand(rentStandClient);
            rentStandRepository.save(rentStandClient);
            clientRepository.save(client);

            return new ResponseEntity<>(new RentStandDTO(rentStandClient), HttpStatus.OK);
        }
    }
}
