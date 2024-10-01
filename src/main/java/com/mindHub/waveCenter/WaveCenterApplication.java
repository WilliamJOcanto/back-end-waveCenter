package com.mindHub.waveCenter;

import com.mindHub.waveCenter.models.*;
import com.mindHub.waveCenter.repositories.*;
import com.mindHub.waveCenter.utils.GenerateHasCode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
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

            Place pabellonMusica = new Place("The Tidal Beat", 40, 0, "Dive into the rhythm at The Tidal Beat, where vibrant music events come alive. This energetic space hosts everything from intimate concerts to electrifying performances, making it the perfect venue for music lovers to experience unforgettable moments.");
            Place pabellonTeatro = new Place("Wave Lounge", 40, 0, "Step into the Wave Lounge, a captivating setting for theater and conferences. Here, engaging performances and thought-provoking talks take center stage, inviting audiences to explore the depths of creativity and knowledge in an inspiring atmosphere.");
            Place pabellonConvenciones = new Place("Wave Crest", 30, 30, "Welcome to Wave Crest, the ideal venue for conventions and gatherings. With versatile space and modern amenities, this salon is designed to accommodate a variety of events, from business meetings to expos, fostering collaboration and innovation.");

            Stand smallStand = new Stand(Arrays.asList(11,12,13,14,15,16,17,18,19,20), "small", 5000.0);
            Stand bigStand = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);


            Event eventCreativeCurrent = new Event("The Creative Current", "Immerse yourself in a creative fair that celebrates local talent. Artists from various disciplines will display their works, from stunning sculptures to vibrant digital illustrations.", Arrays.asList("Sofía Martínez - Painter known for her vibrant abstract landscapes.", "Diego Ruiz - Sculptor who works with recycled materials, creating unique and sustainable works.", "Valeria Gómez - Digital illustrator who combines traditional and digital techniques to tell visual stories."), LocalDate.of(2024, 11, 6), 1000.0, Arrays.asList("../assets/aCreative1.jpg", "../assets/aCreative2.jpg", "../assets/aCreative3.png", "../assets/aCreative4.png", "../assets/aCreative5.jpg"));
            Ticket ticketEventCreativeCurrent = new Ticket(LocalDateTime.of(2024, 11, 6, 15, 0), "Expo Art 2024 - The Creative Current");
            eventCreativeCurrent.addTicket(ticketEventCreativeCurrent);
            eventCreativeCurrent.addStand(smallStand);
            eventCreativeCurrent.addStand(bigStand);
            pabellonConvenciones.addEvent(eventCreativeCurrent);
            pabellonConvenciones.addTicket(ticketEventCreativeCurrent);
            placeRepository.save(pabellonConvenciones);
            eventRepository.save(eventCreativeCurrent);
            ticketRepository.save(ticketEventCreativeCurrent);
            standRepository.save(smallStand);
            standRepository.save(bigStand);

            Stand smallStand1 = new Stand(Arrays.asList(11,12,13,14,15,16,17,18,19,20), "small", 5000.0);
            Stand bigStand1 = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);

            Event eventInnovatorsHaven = new Event("Innovators' Haven", "Explore a unique technology exhibition that fuses art, science and technology. At Innovators' Haven, you'll discover interactive projects, from augmented reality installations to innovations in sustainable design. Visitors will be able to experience first-hand how these disciplines intertwine, stimulating creativity and reflection on the future.", Arrays.asList("LuzTech - Augmented reality installation that transforms urban spaces.", "EcoArt Collective - Sustainable design projects using recycled materials.", "Interactivity Lab - Interactive experiences that combine digital art and technology."), LocalDate.of(2024, 11, 7), 1000.0, Arrays.asList("../assets/aInnovation1.jpg", "../assets/aInnovation2.jpg", "../assets/aInnovation3.jpg", "../assets/aInnovation4.jpg", "../assets/aInnovation5.jpg"));
            Ticket ticketEventInnovatorsHaven = new Ticket(LocalDateTime.of(2024, 11, 7, 15, 0), "Tech Expo 2024 - Innovators' Haven");
            eventInnovatorsHaven.addTicket(ticketEventInnovatorsHaven);
            eventInnovatorsHaven.addStand(smallStand1);
            eventInnovatorsHaven.addStand(bigStand1);
            pabellonConvenciones.addEvent(eventInnovatorsHaven);
            pabellonConvenciones.addTicket(ticketEventInnovatorsHaven);
            placeRepository.save(pabellonConvenciones);
            eventRepository.save(eventInnovatorsHaven);
            ticketRepository.save(ticketEventInnovatorsHaven);
            standRepository.save(smallStand1);
            standRepository.save(bigStand1);


            Stand smallStand2 = new Stand(Arrays.asList(11,12,13,14,15,16,17,18,19,20), "small", 5000.0);
            Stand bigStand2 = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);

            Event eventCulturalMarket = new Event("Cultural Tides Market", "Immerse yourself in a vibrant cultural market that celebrates local creativity. At Cultural Tides Market, you'll find a variety of products, from crafts and independent fashion to eco-friendly products. Additionally, you'll enjoy interactive photography and street art exhibits, where the community comes together to share and appreciate local talent.", Arrays.asList("Ana Torres - Artisan specialized in decorative ceramics.", "Urban Art Collective - Artists presenting live murals and street art.", "EcoFashion Lab - Independent fashion designers using sustainable materials."), LocalDate.of(2024, 11, 8), 1000.0, Arrays.asList("../assets/aTides1.jpg", "../assets/aTides2.jpg", "../assets/aTides3.jpg", "../assets/aTides4.jpeg", "../assets/aTides5.jpg"));
            Ticket ticketEventCulturalMarket = new Ticket(LocalDateTime.of(2024, 11, 8, 15, 0), "Cultural Tides Market 2024");
            eventCulturalMarket.addTicket(ticketEventCulturalMarket );
            eventCulturalMarket.addStand(smallStand2);
            eventCulturalMarket.addStand(bigStand2);
            pabellonConvenciones.addEvent(eventCulturalMarket);
            pabellonConvenciones.addTicket(ticketEventCulturalMarket );
            placeRepository.save(pabellonConvenciones);
            eventRepository.save(eventCulturalMarket);
            ticketRepository.save(ticketEventCulturalMarket );
            standRepository.save(smallStand2);
            standRepository.save(bigStand2);

            Stand smallStand3 = new Stand(Arrays.asList(11,12,13,14,15,16,17,18,19,20), "small", 5000.0);
            Stand bigStand3 = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);

            Event eventHeroesSummit = new Event("Heroes' Summit", "An exciting Comic-Con style event where fans of comics, movies and series come together to enjoy panels with creators, cosplay contests and exclusive geek culture products. In addition, there will be areas dedicated to gaming and virtual reality zones, offering an immersive experience for all attendees.", Arrays.asList("Javier Rodríguez - Comic book artist known for his work at Marvel.", "Clara Ramos - Voice actress famous for her roles in animated series.", "Team GamerPro - Content creators who will present their latest games and virtual reality technology."), LocalDate.of(2024, 11, 9), 1000.0, Arrays.asList("../assets/aHeroes1.png", "../assets/aHeroes2.jpg", "../assets/aHeroes3.webp", "../assets/aHeroes4.jpg", "../assets/aHeroes5.jpg"));
            Ticket ticketHeroesSummit = new Ticket(LocalDateTime.of(2024, 11, 9, 15, 0), "Comic Convention 2024 - Heroes' Summit");
            eventHeroesSummit.addTicket(ticketHeroesSummit);
            eventHeroesSummit.addStand(smallStand3);
            eventHeroesSummit.addStand(bigStand3);
            pabellonConvenciones.addEvent(eventHeroesSummit);
            pabellonConvenciones.addTicket(ticketHeroesSummit);
            placeRepository.save(pabellonConvenciones);
            eventRepository.save(eventHeroesSummit);
            ticketRepository.save(ticketHeroesSummit);
            standRepository.save(smallStand3);
            standRepository.save(bigStand3);

            Stand smallStand4 = new Stand(Arrays.asList(11,12,13,14,15,16,17,18,19,20), "small", 5000.0);
            Stand bigStand4 = new Stand(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "big", 10000.0);

            Event eventCulinaryFest = new Event("Coastal Culinary Fest", "A gastronomic tour that celebrates delicious regional and local food. With chef stands offering traditional dishes, fresh seafood and delicious fusion cuisine, this event is a feast for the senses. Attendees will be able to sample products from local farms and participate in cooking workshops to learn new techniques.", Arrays.asList("María López - Specialist in traditional coastal cuisine.", "Carlos Méndez - Chef recognized for his innovative fusion cuisine.", "Elena Torres - Expert in fresh and sustainable seafood."), LocalDate.of(2024, 11, 10), 1000.0, Arrays.asList("../assets/aComida1.jpg", "../assets/aComida2.jpg", "../assets/aComida3.jpg", "../assets/aComida4.jpg", "../assets/aComida5.jpg"));
            Ticket ticketCulinaryFest = new Ticket(LocalDateTime.of(2024, 11, 10, 15, 0), "Culinary Convention 2024 - Coastal Culinary Fest");
            eventCulinaryFest.addTicket(ticketCulinaryFest);
            eventCulinaryFest.addStand(smallStand4);
            eventCulinaryFest.addStand(bigStand4);
            pabellonConvenciones.addEvent(eventCulinaryFest);
            pabellonConvenciones.addTicket(ticketCulinaryFest);
            placeRepository.save(pabellonConvenciones);
            eventRepository.save(eventCulinaryFest);
            ticketRepository.save(ticketCulinaryFest);
            standRepository.save(smallStand4);
            standRepository.save(bigStand4);


            Event eventJazz = new Event("Rhythms of the Tides", "An independent music festival where each artist brings their unique style, from folk and jazz to electronic music.", Arrays.asList("Luna Waves (Indie Folk)", "The Electric Ocean (Synthwave/Electronic)", "Soul Drifters (Jazz Fusion)", "Desert Echo (Acoustic Rock)"), LocalDate.of(2024, 11, 1), 1000.0, Arrays.asList("../assets/bJazz1.jpg", "../assets/bJazz2.jpg", "../assets/bJazz3.jpg", "../assets/bJazz4.jpg", "../assets/bJazz5.jpg"));
            Ticket ticketEventJazz = new Ticket(LocalDateTime.of(2024, 11, 1, 15, 0), "Jazz Festival 2024 - Rhythms of the Tides");
            eventJazz.addTicket(ticketEventJazz);
            pabellonMusica.addEvent(eventJazz);
            pabellonMusica.addTicket(ticketEventJazz);
            placeRepository.save(pabellonMusica);
            eventRepository.save(eventJazz);
            ticketRepository.save(ticketEventJazz);

            Event eventUnplugged = new Event("Echoes Unplugged", "Enjoy an intimate acoustic evening featuring soulful performances from genres including folk, indie and soft rock. Experience the raw emotion and authenticity of each artist as they create memorable connections through their music.", Arrays.asList("Astral Strings (Indie Acoustic)", "Golden Horizon (Alternative Folk)", "Sunset Reverie (Acoustic Dream Pop)"), LocalDate.of(2024, 11, 2), 1000.0, Arrays.asList("../assets/bEchoes1.jpg", "../assets/bEchoes2.jpg", "../assets/bEchoes3.jpg", "../assets/bEchoes4.jpg", "../assets/bEchoes5.jpg"));
            Ticket ticketEventUnplugged = new Ticket(LocalDateTime.of(2024, 11, 2, 15, 0), "Unplugged Sessions 2024 - Echoes Unplugged");
            eventUnplugged.addTicket(ticketEventUnplugged);
            pabellonMusica.addEvent(eventUnplugged);
            pabellonMusica.addTicket(ticketEventUnplugged);
            placeRepository.save(pabellonMusica);
            eventRepository.save(eventUnplugged);
            ticketRepository.save(ticketEventUnplugged);

            Event eventBeatFest = new Event("Tidal Beat Fest", "Immerse yourself in a night of eclectic sounds, with experimental and lo-fi music. Discover innovative bands that combine ambient textures with nostalgic vibes, creating a unique atmosphere that celebrates creativity and spontaneity. Enjoy this unforgettable musical experience!", Arrays.asList("Cosmic Tones (Experimental Electronics)", "Wave Ritual (Psychedelic Post-Rock)", "Deep Blue Noise (Shoegaze/Noise Pop)"), LocalDate.of(2024, 11, 3), 1000.0, Arrays.asList("../assets/bElectronica1.jpeg", "../assets/bElectronica2.jpg", "../assets/bElectronica3.jpg", "../assets/bElectronica4.jpg", "../assets/bElectronica5.jpg"));
            Ticket ticketEventBeatFest = new Ticket(LocalDateTime.of(2024, 11, 3, 15, 0), "Tidal Fest 2024 - Tidal Beat Fest");
            eventBeatFest.addTicket(ticketEventBeatFest);
            pabellonMusica.addEvent(eventBeatFest);
            pabellonMusica.addTicket(ticketEventBeatFest);
            placeRepository.save(pabellonMusica);
            eventRepository.save(eventBeatFest);
            ticketRepository.save(ticketEventBeatFest);

            Event eventRockConcert = new Event("Rock Tide Concert", "A rock concert that brings together the best local and national bands on an open-air stage, overlooking the sea. No distractions, just the energy of rock in its purest form, where the public can enjoy great classics and new musical proposals.", Arrays.asList("Marea Verde (Alternative Rock)", "The Sonics (Classic Rock)", "Breakup (Hard rock)"), LocalDate.of(2024, 11, 4), 100.0, Arrays.asList("../assets/bRock1.jpg", "../assets/bRock2.jpg", "../assets/bRock3.jpg", "../assets/bRock4.jpg", "../assets/bRock5.jpg"));
            Ticket ticketEventRockConcert = new Ticket(LocalDateTime.of(2024, 11, 4, 15, 0), "Rock Festival 2014 - Rock Tide Concert");
            eventRockConcert.addTicket(ticketEventRockConcert);
            pabellonMusica.addEvent(eventRockConcert);
            pabellonMusica.addTicket(ticketEventRockConcert);
            placeRepository.save(pabellonMusica);
            eventRepository.save(eventRockConcert);
            ticketRepository.save(ticketEventRockConcert);

            Event eventReggaeFestival = new Event("Reggae Vibes Festival", "A unique event that celebrates reggae music and culture in a closed space. With an intimate atmosphere, you will enjoy immersive rhythms and a positive message while you immerse yourself in the energy of live performances. Come share a night full of good vibes!", Arrays.asList("Tropicana Rasta (Reggae fusion)", "Roots of the Sea (Roots reggae)", "Caribbean Sound (Reggae dub)"), LocalDate.of(2024, 11, 5), 100.0, Arrays.asList("../assets/", "", "", "", ""));
            Ticket ticketEventReggaeFestival = new Ticket(LocalDateTime.of(2024, 11, 5, 15, 0), "Reggae Festival 2024 - Reggae Vibes Festival");
            eventReggaeFestival.addTicket(ticketEventReggaeFestival);
            pabellonMusica.addEvent(eventReggaeFestival);
            pabellonMusica.addTicket(ticketEventReggaeFestival);
            placeRepository.save(pabellonMusica);
            eventRepository.save(eventReggaeFestival);
            ticketRepository.save(ticketEventReggaeFestival);


            Event eventVoicesFuture = new Event("Voices of the Future", "A series of talks that addresses social innovation, the environment and cultural activism. Visionary speakers will share their projects and movements that are transforming the world, inspiring attendees to be part of the change.", Arrays.asList("Sofía García - Environmental activist and founder of a conservation organization.", "Luis Fernández - Social innovator focused on sustainable communities."), LocalDate.of(2024, 12, 5), 1000.0, Arrays.asList("../assets/cMedioambiente1.jpg", "../assets/cMedioambiente2.png", "../assets/cMedioambiente3.jpg", "../assets/cMedioambiente4.jpg", "../assets/cMedioambiente5.jpg"));
            Ticket ticketEventVoicesFuture = new Ticket(LocalDateTime.of(2024, 12, 5, 15, 0), "Voices of the Future Conference 2024");
            eventVoicesFuture.addTicket(ticketEventVoicesFuture);
            pabellonTeatro.addEvent(eventVoicesFuture);
            pabellonTeatro.addTicket(ticketEventVoicesFuture);
            placeRepository.save(pabellonTeatro);
            eventRepository.save(eventVoicesFuture);
            ticketRepository.save(ticketEventVoicesFuture);


            Event eventArtStorytelling = new Event("The Art of Storytelling", "An event dedicated to the art of storytelling. Storytellers, writers and poets will take the stage to share unique stories that will captivate and inspire the audience. Enjoy a magical night full of emotions, imagination and the powerful connection that only a good story can offer.", Arrays.asList("Javier Ríos - Storyteller known for his captivating fables.", "Ana Beltrán - Poet whose words evoke deep emotions.", "Diego Martínez - Writer of short stories that challenge reality."), LocalDate.of(2024, 12, 6), 1000.0, Arrays.asList("../assets/cPoesia1.jpg", "../assets/cPoesia2.jpg", "../assets/cPoesia3.jpg", "../assets/cPoesia4.jpg", "../assets/cPoesia5.jpg"));
            Ticket ticketEventArtStorytelling = new Ticket(LocalDateTime.of(2024, 12, 6, 15, 0), "Art Conference 2024 - The Art of Storytelling");
            eventArtStorytelling.addTicket(ticketEventArtStorytelling);
            pabellonTeatro.addEvent(eventArtStorytelling);
            pabellonTeatro.addTicket(ticketEventArtStorytelling);
            placeRepository.save(pabellonTeatro);
            eventRepository.save(eventArtStorytelling);
            ticketRepository.save(ticketEventArtStorytelling);


            Event eventCurrentsTalks = new Event("Cultural Currents Talks", "A series of inspiring talks that explore the intersection of technology and art. Discover how new digital tools are transforming the creative process, offering new possibilities to artists and creators.", Arrays.asList("María Ruiz - Digital artist who uses augmented reality in her works.", "Tomás Herrera - Graphic designer focused on the fusion of art and technology.", "Elena Soto - Expert in creative tools and their impact on artistic production."), LocalDate.of(2024, 12, 7), 1000.0, Arrays.asList("../assets/cArteDigital1.jpg", "../assets/cArteDigital2.jpg", "../assets/cArteDigital3.jpg", "../assets/cArteDigital4.jpg", "../assets/cArteDigital5.jpg"));
            Ticket ticketEventCurrentsTalks = new Ticket(LocalDateTime.of(2024, 12, 7, 15, 0), "Tech & Art Conference 2024 - Cultural Currents Talks");
            eventCurrentsTalks.addTicket(ticketEventCurrentsTalks);
            pabellonTeatro.addEvent(eventCurrentsTalks);
            pabellonTeatro.addTicket(ticketEventCurrentsTalks);
            placeRepository.save(pabellonTeatro);
            eventRepository.save(eventCurrentsTalks);
            ticketRepository.save(ticketEventCurrentsTalks);


            Event eventMoonlitShow = new Event("The Moonlit Show", "A series of nighttime performances at Wave Crest that combine shadow theater with artistic lighting, creating a magical atmosphere. This event is ideal for special cultural nights, offering a unique experience that transports the public to a world of fantasy and creativity.", Arrays.asList("Sombra Mística Company - Masters of shadow theater with captivating narratives.", "Light and Fantasy - Artists creating dazzling lighting shows.", "Eclectic Theater Cast - Group that fuses dance and theater in their performances."), LocalDate.of(2024, 12, 8), 1000.0, Arrays.asList("../assets/cLuz1.jpg", "../assets/cLuz2.jpg", "../assets/cLuz3.jpg", "../assets/cLuz4.png", "../assets/cLuz5.jpg"));
            Ticket ticketEventMoonlitShow = new Ticket(LocalDateTime.of(2024, 12, 8, 15, 0), "Theater performances - The Moonlit Show");
            eventMoonlitShow.addTicket(ticketEventMoonlitShow);
            pabellonTeatro.addEvent(eventMoonlitShow);
            pabellonTeatro.addTicket(ticketEventMoonlitShow);
            placeRepository.save(pabellonTeatro);
            eventRepository.save(eventMoonlitShow);
            ticketRepository.save(ticketEventMoonlitShow);


            Event eventSymphonyWaves = new Event("Symphony of the Waves", "An elegant concert of classical and orchestral music in an exquisite hall with numbered seats. Attendees will be able to delight in a selection of pieces performed by a talented local philharmonic orchestra, ranging from classical compositions to captivating contemporary soundtracks.", Arrays.asList("Filarmónica del Mar - Known for its versatility and emotion in each performance."), LocalDate.of(2024, 12, 9), 1000.0, Arrays.asList("../assets/cOrquesta1.jpg", "../assets/cOrquesta2.jpg", "../assets/cOrquesta3.jpg", "../assets/cOrquesta4.jpg", "../assets/cOrquesta5.jpg"));
            Ticket ticketEventSymphonyWaves = new Ticket(LocalDateTime.of(2024, 12, 9, 15, 0), "Symphony of the Waves 2024");
            eventSymphonyWaves.addTicket(ticketEventSymphonyWaves);
            pabellonTeatro.addEvent(eventSymphonyWaves);
            pabellonTeatro.addTicket(ticketEventSymphonyWaves);
            placeRepository.save(pabellonTeatro);
            eventRepository.save(eventSymphonyWaves);
            ticketRepository.save(ticketEventSymphonyWaves);



            // Crear primer cliente
            Client ludwing = new Client("Ludwing", "Valecillos", "ludwingval@gmail.com", passwordEncoder.encode("123"));
            clientRepository.save(ludwing);

            // Crear tarjeta para el primer cliente
            Cards card1 = new Cards("Ludwing Valecillos", 123, "1234-5678-9012-3456", LocalDate.now().plusYears(4), CardType.DEBIT, PaymentNetwork.VISA);
            ludwing.addCard(card1);
            cardsRepository.save(card1);
            clientRepository.save(ludwing);


            Place salaDeConvenciones = new Place("Sunset Beach", 10, 200, "A beautiful beach for concerts and events.");
            placeRepository.save(salaDeConvenciones);

            // Crear evento
            Event beachEvent = new Event("Beach Party", "A summer beach party",Arrays.asList("Filarmónica del Mar - Known for its versatility and emotion in each performance."), LocalDate.now().plusDays(30), 50.00, Arrays.asList("image1.jpg", "image2.jpg"));
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
