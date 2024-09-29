package com.mindHub.waveCenter.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class RentStand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String hashCode;
    private List<Integer> rentedPositions;
    private LocalDateTime rentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client owner;

    @ManyToOne
    @JoinColumn(name = "stand_id")
    private Stand stand;

    public RentStand() {
    }

    public RentStand(String name, String description, String hashCode, List<Integer> rentedPositions, LocalDateTime rentDate) {
        this.name = name;
        this.description = description;
        this.hashCode = hashCode;
        this.rentedPositions = rentedPositions;
        this.rentDate = rentDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public List<Integer> getRentedPositions() {
        return rentedPositions;
    }

    public void setRentedPositions(List<Integer> rentedPositions) {
        this.rentedPositions = rentedPositions;
    }

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    @Override
    public String toString() {
        return "RentStand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", rentedPositions=" + rentedPositions +
                ", rentDate=" + rentDate +
                '}';
    }
}
