package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTicketRepository extends JpaRepository<OrderTicket, Long> {
    boolean existsByHashCode(String hashCode);

}
