package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.demo.app.ticket.TicketBookingSerive;
import com.example.demo.app.ticket.entity.Ticket;

public class TicketBookingSeriveTest {

	@Test
	public void testregisterStation() {
		TicketBookingSerive service = new TicketBookingSerive();
		Ticket t  =service.getTicket(1);
		assertNotNull(t);
	}
}
