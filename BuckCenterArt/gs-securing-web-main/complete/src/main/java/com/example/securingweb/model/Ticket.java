package com.example.securingweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adjust the strategy based on your database
    private Long id;
 

    private String event;
    private String seat;
    private double price;
    private String movieImage;  // New field for movie image URL

    // Constructors
    public Ticket() {
        // Default constructor required by JPA
    }

    // Constructor with movie image
    public Ticket(String event, String seat, double price, String movieImage) {
        this.event = event;
        this.seat = seat;
        this.price = price;
        this.movieImage = movieImage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }
}
