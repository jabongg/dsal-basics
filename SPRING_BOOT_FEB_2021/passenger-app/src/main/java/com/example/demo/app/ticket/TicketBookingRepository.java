package com.example.demo.app.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.app.ticket.entity.Station;
import com.example.demo.app.ticket.entity.Ticket;

@Repository
public interface TicketBookingRepository extends JpaRepository<Ticket, Integer> {

	Ticket findByTicketId(Integer ticketId);

}
