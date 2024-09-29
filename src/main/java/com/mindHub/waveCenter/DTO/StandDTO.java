package com.mindHub.waveCenter.DTO;

import java.util.ArrayList;
import java.util.List;

public class StandDTO {
    private long id;

    private  double price;

    private String location;

    private String size;

    private List<RentStandDTO> stands = new ArrayList<>();

    public StandDTO(Stand stand) {
        this.id = stand.getId();
        this.price = stand.getPrice();
        this.location = stand.getLocation();
        this.size = stand.getSize();
        this.stands = stand.getStands().stream().map(RentStandDTO::new).toList();
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getSize() {
        return size;
    }

    public List<RentStandDTO> getStands() {
        return stands;
    }
}
