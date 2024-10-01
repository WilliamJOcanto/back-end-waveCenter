package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.ClientDTO;
import com.mindHub.waveCenter.DTO.OrderTicketDTO;
import com.mindHub.waveCenter.DTO.TicketAplicationDTO;
import com.mindHub.waveCenter.models.Client;
import com.mindHub.waveCenter.models.Event;
import com.mindHub.waveCenter.models.OrderTicket;
import com.mindHub.waveCenter.models.Ticket;
import com.mindHub.waveCenter.repositories.ClientRepository;
import com.mindHub.waveCenter.repositories.EventRepository;
import com.mindHub.waveCenter.repositories.OrderTicketRepository;
import com.mindHub.waveCenter.repositories.TicketRepository;
import com.mindHub.waveCenter.services.TicketSercvices;
import com.mindHub.waveCenter.utils.GenerateHasCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServicesImpl implements TicketSercvices {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GenerateHasCode generateHasCode;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private OrderTicketRepository orderTicketRepository;

    private Client getClient(Authentication authentication) {
        return clientRepository.findByEmail(authentication.getName());
    }

    private Event getEvent(long eventId) {
        return eventRepository.getById(eventId);
    }

    private Ticket getTicket(Event event) {
        return event.getTickets().get(0);
    }

    public int getTotalOrders(Event event) {
        return event.getTickets()
                .stream()
                .flatMap(t -> t.getOrderTickets().stream())
                .mapToInt(OrderTicket::getQuantity)
                .sum();
    }

    @Transactional
    @Override
    public ResponseEntity<?> buyTicket(Authentication authentication, TicketAplicationDTO ticketAplicationDTO) {
        if (filters(ticketAplicationDTO) != null) {
            return filters(ticketAplicationDTO);
        }

        Event event = getEvent(ticketAplicationDTO.eventId());
        Ticket ticket = getTicket(event);

        int totalOrders = getTotalOrders(event);

        if (totalOrders + ticketAplicationDTO.quantity() > event.getPlace().getTicketMaxCapacity()) {
            return ResponseEntity.badRequest().body("No space available for this event");
        }

        OrderTicket orderTicket = new OrderTicket(LocalDateTime.now(), ticketAplicationDTO.quantity(), generateHasCode.generateHashCodeOrderTicket());

        ticket.addOrderTicket(orderTicket);
        getClient(authentication).addOrderTicket(orderTicket);


        orderTicketRepository.save(orderTicket);

        return ResponseEntity.ok(new OrderTicketDTO(orderTicket));
    }

    @Override
    public ResponseEntity<?> filters(TicketAplicationDTO ticketAplicationDTO) {
        if (ticketAplicationDTO.eventId() == 0 || !eventRepository.existsById(ticketAplicationDTO.eventId())) {
            return new ResponseEntity<>("Please enter a valid event", HttpStatus.BAD_REQUEST);
        }

        if (ticketAplicationDTO.quantity() == 0) {
            return new ResponseEntity<>("Please enter a valid quantity", HttpStatus.BAD_REQUEST);
        }

        return null;
    }
}
