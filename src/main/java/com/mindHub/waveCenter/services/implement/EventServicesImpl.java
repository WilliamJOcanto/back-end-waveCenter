package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.CreateEventDTO;
import com.mindHub.waveCenter.DTO.EventDTO;
import com.mindHub.waveCenter.models.Event;
import com.mindHub.waveCenter.models.Place;
import com.mindHub.waveCenter.models.Stand;
import com.mindHub.waveCenter.models.Ticket;
import com.mindHub.waveCenter.repositories.EventRepository;
import com.mindHub.waveCenter.repositories.PlaceRepository;
import com.mindHub.waveCenter.repositories.StandRepository;
import com.mindHub.waveCenter.repositories.TicketRepository;
import com.mindHub.waveCenter.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class EventServicesImpl implements EventServices {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private StandRepository standRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok( eventRepository.findAll().stream().map(EventDTO::new).toList());
    }

    @Override
    public Event eventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> getEventDtoById(Long id) {
        if(eventById(id) == null){
            return new ResponseEntity<>("Event whit the id: " + id + ", not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new EventDTO(eventById(id)), HttpStatus.OK);
    }

    @Override
    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean textValidator(String text) {
        return text.isBlank();
    }

    @Override
    public Boolean arraysValidator(List<String> collection) {
        return collection.isEmpty();
    }

    @Override
    public Boolean dateFieldValidator(LocalDate date) {
        return date == null;
    }

    @Override
    public Boolean priceFieldValidator(Double price) {
        return price == null || price.isNaN();
    }

    @Override
    public Boolean placeIdFieldValidator(Long id) {
        return id == null || id < 0;
    }

    @Override
    public ResponseEntity<?> requestValidator(CreateEventDTO createEventDTO) {

        if(textValidator(createEventDTO.name())){
            return new ResponseEntity<>("The name event field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(textValidator(createEventDTO.description())){
            return new ResponseEntity<>("The description event field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(dateFieldValidator(createEventDTO.date())){
            return new ResponseEntity<>("The date field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(priceFieldValidator(createEventDTO.ticketPrice())){
            return new ResponseEntity<>("The price event field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(arraysValidator(createEventDTO.images())){
            return new ResponseEntity<>("The images URL´s field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(placeIdFieldValidator(createEventDTO.placeId())){
            return new ResponseEntity<>("The place field must not be empty", HttpStatus.FORBIDDEN);
        }
        if(eventRepository.existsByDateAndPlace_Id(createEventDTO.date(), createEventDTO.placeId()) && eventRepository.existsByName(createEventDTO.name())){
            return new ResponseEntity<>("This type of event already exists for the selected date and place", HttpStatus.FORBIDDEN);
        }
        if(createEventDTO.date().isBefore(LocalDate.now())){
            return new ResponseEntity<>("The date entered has expired", HttpStatus.FORBIDDEN);
        }
        return null;
    }

    @Override
    public ResponseEntity<?> makeNewEvent(CreateEventDTO createEventDTO) {

        ResponseEntity<?> responseValidator = requestValidator(createEventDTO);
        if(responseValidator != null){
            return responseValidator;
        }

        Place place = getPlaceById(createEventDTO.placeId());
        Event event = new Event(createEventDTO.name(), createEventDTO.description(), createEventDTO.artists(), createEventDTO.date(), createEventDTO.ticketPrice(), createEventDTO.images());
        Ticket ticket = new Ticket(createEventDTO.date().atTime(15, 0), createEventDTO.name());

        eventRepository.save(event);
        event.addTicket(ticket);
        place.addTicket(ticket);
        place.addEvent(event);
        placeRepository.save(place);

        if(createEventDTO.placeId() == 1){
            Stand smallStand = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30, 31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50), "small", 5000.0);
            Stand bigStand = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);

            smallStand.setEvent(event);
            bigStand.setEvent(event);
            standRepository.save(smallStand);
            standRepository.save(bigStand);
            event.addStand(smallStand);
            event.addStand(bigStand);

        }else if (createEventDTO.placeId() == 3) {
            Stand stand = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30), "small", event.getTicketPrice());

            stand.setEvent(event);
            standRepository.save(stand);
            event.addStand(stand);
        }
        ticketRepository.save(ticket);

        return new ResponseEntity<>(new EventDTO(event), HttpStatus.OK);
    }

}
