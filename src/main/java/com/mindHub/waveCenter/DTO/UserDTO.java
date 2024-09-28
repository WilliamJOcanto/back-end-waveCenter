package com.mindHub.waveCenter.DTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private long id;
    private String firstName;

    private String lastName;

    private String email;

    private List<Ticket> tickets;

    private List<userStand> stands;

    public UserDTO(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.tickets = user.getTickets().stream().map(TicketDTO::new).collect(Collectors.toList());
        this.stands = user.stands.stream().map(StanDTO::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Stand> getStands() {
        return stands;
    }
}
