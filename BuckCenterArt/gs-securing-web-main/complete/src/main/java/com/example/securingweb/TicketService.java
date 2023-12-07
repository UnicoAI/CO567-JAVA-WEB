package com.example.securingweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.securingweb.model.Ticket;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public Ticket bookTicket(String event, String seat, Double price) {
        // Add logic to check seat availability, calculate price, etc.
        // For simplicity, let's assume the price is fixed for all seats.
        
        Ticket ticket = new Ticket();
        ticket.setEvent(event);
        ticket.setSeat(seat);
        ticket.setPrice(price);
       
        return ticketRepository.save(ticket);
    }
     public Ticket bookMovie(String event, String seat, Double price, String movieImage) {
        // Add logic to check seat availability, calculate price, etc.
        // For simplicity, let's assume the price is fixed for all seats.
        Ticket ticket = new Ticket();
       ticket.setEvent(event);
        ticket.setSeat(seat);
        ticket.setPrice(price);
        ticket.setMovieImage(movieImage);
        return ticketRepository.save(ticket);
    }


}
