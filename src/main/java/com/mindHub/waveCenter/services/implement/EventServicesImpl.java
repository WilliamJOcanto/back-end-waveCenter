package com.mindHub.waveCenter.services.implement;

import com.mindHub.waveCenter.DTO.EventDTO;
import com.mindHub.waveCenter.repositories.EventRepository;
import com.mindHub.waveCenter.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServicesImpl implements EventServices {

    @Autowired
    EventRepository eventRepository;
    @Override
    public ResponseEntity<?> getAllEvents() {
        System.out.println("a");
        return ResponseEntity.ok( eventRepository.findAll().stream().map(EventDTO::new).toList());
    }
}
