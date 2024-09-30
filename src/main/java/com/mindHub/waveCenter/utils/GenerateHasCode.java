package com.mindHub.waveCenter.utils;

import com.mindHub.waveCenter.repositories.OrderTicketRepository;
import com.mindHub.waveCenter.repositories.RentStandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class GenerateHasCode {

    @Autowired
    private RentStandRepository rentStandRepository;

    @Autowired
    private OrderTicketRepository orderTicketRepository;


    public String generateRandomNumber() {
        Random random = new Random();// Genera un número aleatorio entre 100 y 999
        return Integer.toString(random.nextInt((9999 - 1000) + 1) + 100);
    }

    @Bean
    public String generateHashCodeRentStand() {
        String number = generateRandomNumber();

        while (rentStandRepository.existsByHashCode(prefijo() + number)) {
            number = generateRandomNumber();
        }

        return prefijo() + number;
    }
    @Bean
    public String generateHashCodeOrderTicket() {
        String number = generateRandomNumber();

        while (orderTicketRepository.existsByHashCode(prefijo() + number)) {
            number = generateRandomNumber();
        }

        return prefijo() + number;
    }


    public String prefijo() {
        return "WAVE";
    }
}
