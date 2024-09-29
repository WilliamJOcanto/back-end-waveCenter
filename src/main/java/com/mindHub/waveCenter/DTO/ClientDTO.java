//package com.mindHub.waveCenter.DTO;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//public class ClientDTO {
//    private long id;
//    private String name;
//    private String firtsName;
//    private String LastName;
//
//    private String email;
//    private String password;
//
//    private List<OrderTicketDTO> tickets = new ArrayList<>();
//
//    private List<RentStandDTO> rents = new ArrayList<>();
//
//    private List<CardDTO> cards = new ArrayList<>();
//
//    public ClientDTO(Client client){
//
//        this.id = client.getId();
//        this.name = client.getName();
//        this.firtsName = client.getFirtsName();
//        this.LastName = client.getLastName();
//        this.email = client.getEmail();
//        this.password = client.getPassword();
//        this.tickets = client.getTickets().stream().map(OrderTicketDTO::new).toList();
//        this.rents = client.getRents().stream().map(RentStandDTO::new).toList();
//        this.cards = client.getCards().stream().map(CardDTO::new).toList();
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getFirtsName() {
//        return firtsName;
//    }
//
//    public String getLastName() {
//        return LastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public List<OrderTicketDTO> getTickets() {
//        return tickets;
//    }
//
//    public List<RentStandDTO> getRents() {
//        return rents;
//    }
//
//    public List<CardDTO> getCards() {
//        return cards;
//    }
//}
