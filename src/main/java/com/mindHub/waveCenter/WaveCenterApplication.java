package com.mindHub.waveCenter;

import com.mindHub.waveCenter.models.*;
import com.mindHub.waveCenter.repositories.*;
import com.mindHub.waveCenter.utils.GenerateHasCode;
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
    public CommandLineRunner initData(ClientRepository clientRepository,
                                      CardRepository cardsRepository,
                                      EventRepository eventRepository,
                                      OrderTicketRepository orderTicketRepository,
                                      PlaceRepository placeRepository,
                                      TicketRepository ticketRepository,
                                      PasswordEncoder passwordEncoder,
                                      StandRepository standRepository,
                                      RentStandRepository rentStandRepository,
                                      GenerateHasCode generateHasCode) {

        return args -> {
            // Crear primer cliente
            Client ludwing = new Client("Ludwing", "Valecillos", "ludwingval@gmail.com", passwordEncoder.encode("123"));
            clientRepository.save(ludwing);

            // Crear tarjeta para el primer cliente
            Cards card1 = new Cards("Ludwing Valecillos", 123, "1234-5678-9012-3456", LocalDate.now().plusYears(4), CardType.DEBIT, PaymentNetwork.VISA);
            ludwing.addCard(card1);
            cardsRepository.save(card1);

            // Crear lugar (Place)
            Place salaDeConvenciones = new Place("Sunset Beach", 10, 200, "A beautiful beach for concerts and events.");
            placeRepository.save(salaDeConvenciones);

            // Crear evento
            Event beachEvent = new Event("Beach Party", "A summer beach party", LocalDate.now().plusDays(30), 50.00, Arrays.asList("image1.jpg", "image2.jpg"));
            salaDeConvenciones.addEvent(beachEvent);
            eventRepository.save(beachEvent);

            // Crear tickets asociados al evento
            Ticket ticket2 = new Ticket(LocalDateTime.now(), "Beach Party VIP Admission");
            beachEvent.addTicket(ticket2);
            salaDeConvenciones.addTicket(ticket2);
            ticketRepository.save(ticket2);

            // Crear orden de compra (OrderTicket)
            OrderTicket orderTicket1 = new OrderTicket(LocalDateTime.now(), 2, generateHasCode.generateHashCodeOrderTicket());
            ludwing.addOrderTicket(orderTicket1);
            ticket2.addOrderTicket(orderTicket1);
            orderTicketRepository.save(orderTicket1);

            // Crear Stand
            Stand beachStand = new Stand(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30), "Large", 200.00);
            beachEvent.addStand(beachStand);
            standRepository.save(beachStand);

            // Cliente renta un stand
            RentStand rentStand1 = new RentStand("Stand 1", "Beach VIP Stand", generateHasCode.generateHashCodeRentStand(), Arrays.asList(1, 2), LocalDateTime.now());
            ludwing.addRentStand(rentStand1);
            beachStand.addRentStand(rentStand1);
            rentStandRepository.save(rentStand1);

            // Imprimir detalles del pedido
            System.out.println(orderTicket1.getTicket());

            // Crear segundo cliente
            Client ana = new Client("Ana", "Gomez", "ana.gomez@example.com", passwordEncoder.encode("abc123"));
            clientRepository.save(ana);

            // Crear tarjeta para el segundo cliente
            Cards card2 = new Cards("Ana Gomez", 456, "9876-5432-1098-7654", LocalDate.now().plusYears(4), CardType.CREDIT, PaymentNetwork.MASTERCARD);
            ana.addCard(card2);
            cardsRepository.save(card2);

            // Crear orden de compra para el segundo cliente
            OrderTicket orderTicket2 = new OrderTicket(LocalDateTime.now(), 3, generateHasCode.generateHashCodeOrderTicket());
            ana.addOrderTicket(orderTicket2);
            ticket2.addOrderTicket(orderTicket2);
            orderTicketRepository.save(orderTicket2);

            // Cliente renta un stand
            RentStand rentStand2 = new RentStand("Stand 2", "Beach Standard Stand", generateHasCode.generateHashCodeRentStand(), Arrays.asList(2, 3, 4), LocalDateTime.now());
            ana.addRentStand(rentStand2);
            beachStand.addRentStand(rentStand2);
            rentStandRepository.save(rentStand2);

            // Imprimir detalles del pedido para el segundo cliente
            System.out.println(orderTicket2.getTicket());
        };
    }
}
