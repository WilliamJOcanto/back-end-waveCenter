package com.mindHub.waveCenter.DTO;

import com.mindHub.waveCenter.models.Stand;
import java.util.List;

public class StandDTO {

    private long id;
    private List<Integer> locations;
    private String size;
    private double price;

    public StandDTO(Stand stand) {
        this.id = stand.getId();
        this.locations = stand.getLocations();
        this.size = stand.getSize();
        this.price = stand.getPrice();
    }

    public long getId() {
        return id;
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }


}
