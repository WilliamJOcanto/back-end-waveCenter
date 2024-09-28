package com.mindHub.waveCenter.DTO;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class UserStandDTO {
    private long id;

    private String location;

    private double price;

    private LocalDateTime date;


    public UserStandDTO(UserStand userStand) {
        this.id = userStand.getId();
        this.location = userStand.getLocation();
        this.price = userStand.getPrice();
        this.date = userStand.getDate();
    }

}
