package com.example.demo.app.ticket;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.ticket.entity.Ticket;

@RestController
@RequestMapping("/api")
public class TicketBookingController {

	@Autowired
	private TicketBookingSerive ticketBookingSerive;

	@PostMapping("/ticket/bookticket")
	public Ticket bookTicket(@RequestBody TicketRequest ticketRequest
	/*
	 * ,@RequestPart("bookingDate") LocalDateTime bookingDate,
	 * 
	 * @RequestPart("bookingTime") LocalDate bookingTime
	 */) {

		return ticketBookingSerive.bookTicket(ticketRequest);
	}

	@PostMapping("/get-avaialable-trains")
	public Ticket getAvailableTrains(@RequestBody TrainAvailabilityRequest request) {

		return ticketBookingSerive.getAvailableTrains(request);
	}

	@GetMapping("/ticket/ticketId/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingSerive.getTicket(ticketId);
	}

	@GetMapping("/admin/ticket/alltickets")
	public Iterable<Ticket> getAllTickets() {
		return ticketBookingSerive.getAllTickets();
	}

	@PostMapping("/register-station")
	public com.example.demo.app.ticket.entity.Station registerStation(@RequestBody Station station) {
		com.example.demo.app.ticket.entity.Station stationEntity = new com.example.demo.app.ticket.entity.Station();
		//stationEntity.setId(station.getId() == null ? new Random().nextInt(1) : Integer.parseInt(station.getId()));
		stationEntity.setStationId(Integer.parseInt(station.getId()));
		stationEntity.setStationName(station.getStationName());
		stationEntity.setStationCode(station.getStationCode());
		return ticketBookingSerive.registerStation(stationEntity);
	}
}
