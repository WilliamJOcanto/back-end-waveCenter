package com.mindHub.waveCenter.repositories;

import com.mindHub.waveCenter.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
}
