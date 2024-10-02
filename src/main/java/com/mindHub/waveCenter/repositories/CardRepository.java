package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.Cards;
import com.mindHub.waveCenter.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cards, Long> {
    boolean existsByNumberAndOwner(String number, Client owner);
}
