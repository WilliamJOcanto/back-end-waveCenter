//package com.mindHub.waveCenter.DTO;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RentStandDTO {
//    private long id;
//
//    private String description;
//
//    private String name;
//
//    private String hashCode;
//
//    private List<StandDTO> stands = new ArrayList<>()>;
//
//    private LocalDate renDate;
//
////    private LocalDate devDate;
////
////    private double price;
////
////    private List<TicketDTO> tickets = new ArrayList<>()>;
//
//    public RentStandDTO(RentStand rentStand) {
//        this.id = rentStand.getId();
//        this.description = rentStand.getDescription();
//        this.name = rentStand.getName();
//        this.hashCode = rentStand.getHashCode();
//        this.stands = rentStand.getStands().stream().map(StandDTO::new).toList();
//        this.renDate = rentStand.getRenDate();
//        this.devDate = rentStand.getDevDate();
//        this.price = rentStand.getPrice();
//        this.tickets = rentStand.getTickets().stream().map(TicketDTO::new).toList();
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getHashCode() {
//        return hashCode;
//    }
//
//    public List<StandDTO> getStands() {
//        return stands;
//    }
//
//    public LocalDate getRenDate() {
//        return renDate;
//    }
//}
