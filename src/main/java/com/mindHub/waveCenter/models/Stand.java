package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private List<Integer> locations;
    private String size;
    private double price;

    @OneToMany(mappedBy = "stand", fetch = FetchType.EAGER)
    private List<RentStand> rentStands;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;



    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public void addRentStand(RentStand rentStand){
        this.rentStands.add(rentStand);
        rentStand.setStand(this);
    }
}
