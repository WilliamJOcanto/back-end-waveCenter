package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findById(long id);
    Boolean existsByDateAndPlace_Id(LocalDate date, Long placeId);
    Boolean existsByName(String name);
    Boolean existsByDescription(String description);
}
