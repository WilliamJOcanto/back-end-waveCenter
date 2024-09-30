package com.mindHub.waveCenter;

import com.mindHub.waveCenter.models.*;
import com.mindHub.waveCenter.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class WaveCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaveCenterApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ClientRepository clientRepository, CardRepository cardsRepository, EventRepository eventRepository,
                                      OrderTicketRepository orderTicketRepository, PlaceRepository placeRepository, TicketRepository ticketRepository, PasswordEncoder passwordEncoder) {

        return args -> {

            // Crear cliente
            Client ludwing = new Client("Ludwing", "Valecillos", "ludwingval@gmail.com", passwordEncoder.encode("123"));

            // Guardar clientes
            clientRepository.save(ludwing);

            // Crear tarjeta
            Cards card1 = new Cards("Ludwing Valecillos", 123, "1234-5678-9012-3456", LocalDate.now().plusYears(4), CardType.DEBIT, PaymentNetwork.VISA);
            ludwing.addCard(card1);
            cardsRepository.save(card1);

            // Crear lugar (Place)
            Place salaDeConvenciones = new Place("Sunset Beach", 5000, 200, "A beautiful beach for concerts and events.");
            placeRepository.save(salaDeConvenciones);

            // Crear evento
            Event beachEvent = new Event("Beach Party", "A summer beach party", LocalDate.now().plusDays(30), 50.00, Arrays.asList("image1.jpg", "image2.jpg"));
            salaDeConvenciones.addEvent(beachEvent);
            eventRepository.save(beachEvent);

            // Crear tickets asociados al evento
            Ticket ticket2 = new Ticket(LocalDateTime.now(), "Beach Party VIP Admission");
            beachEvent.addTicket(ticket2);

            salaDeConvenciones.addTicket(ticket2);

            // Guardar tickets
            ticketRepository.save(ticket2);

            // Crear orden de compra (OrderTicket)
            OrderTicket orderTicket1 = new OrderTicket(LocalDateTime.now(), 2, "ABC123XYZ");
            ludwing.addOrderTicket(orderTicket1);
            ticket2.addOrderTicket(orderTicket1);
            orderTicketRepository.save(orderTicket1);

            System.out.println(orderTicket1.getTicket());

        };
    }
}
