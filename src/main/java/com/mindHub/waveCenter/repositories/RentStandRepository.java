package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.RentStand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentStandRepository extends JpaRepository<RentStand, Long> {
    boolean existsByHashCode(String hashCode);

}
