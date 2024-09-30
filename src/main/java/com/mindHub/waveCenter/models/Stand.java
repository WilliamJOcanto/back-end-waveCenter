package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @Column(name = "locations")
    private List<Integer> locations;
    private String size;
    private double price;

    @OneToMany(mappedBy = "stand", fetch = FetchType.EAGER)
    private List<RentStand> rentStands = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id")
    private Event event;

    public Stand() {
    }

    public Stand(long id, List<Integer> locations, String size, double price) {
        this.id = id;
        this.locations = locations;
        this.size = size;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public List<Integer> getLocations() {
        return locations;
    }

    public void setLocations(List<Integer> locations) {
        this.locations = locations;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<RentStand> getRentStands() {
        return rentStands;
    }

    public void setRentStands(List<RentStand> rentStands) {
        this.rentStands = rentStands;
    }

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

    @Override
    public String toString() {
        return "Stand{" +
                "id=" + id +
                ", locations=" + locations +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", rentStands=" + rentStands +
                '}';
    }
}
