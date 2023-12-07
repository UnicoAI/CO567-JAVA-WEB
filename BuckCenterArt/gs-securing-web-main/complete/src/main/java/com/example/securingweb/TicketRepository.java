package com.example.securingweb;

import org.springframework.data.repository.CrudRepository;

import com.example.securingweb.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
