package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {
}
