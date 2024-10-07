package com.mindHub.waveCenter.utils;

import com.mindHub.waveCenter.repositories.OrderTicketRepository;
import com.mindHub.waveCenter.repositories.RentStandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class GenerateHasCode {

    @Autowired
    private RentStandRepository rentStandRepository;

    @Autowired
    private OrderTicketRepository orderTicketRepository;

    // Método para generar un número aleatorio entre 100000 y 999999 para mayor variabilidad
    public String generateRandomNumber() {
        Random random = new Random();
        return Integer.toString(random.nextInt(900000) + 100000); // Rango: 100000 - 999999
    }

    // Método para generar un código único para RentStand
    public String generateHashCodeRentStand() {
        String number = generateRandomNumber();

        // Asegurarse de que el código generado no exista en el repositorio
        while (rentStandRepository.existsByHashCode(prefijo() + number)) {
            number = generateRandomNumber();
        }

        return prefijo() + number;
    }

    // Método para generar un código único para OrderTicket
    public String generateHashCodeOrderTicket() {
        String number = generateRandomNumber();

        // Asegurarse de que el código generado no exista en el repositorio
        while (orderTicketRepository.existsByHashCode(prefijo() + number)) {
            number = generateRandomNumber();
        }

        return prefijo() + number;
    }

    // Método que retorna el prefijo común
    public String prefijo() {
        return "WAVE";
    }
}
