package com.example.demo.app.ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.ticket.entity.Station;
import com.example.demo.app.ticket.entity.Ticket;

@Service
public class TicketBookingSerive {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Autowired 
	private StationRepository stationRepository;

	public Ticket getTicket(Integer ticketId) {
		return ticketBookingRepository.findByTicketId(ticketId);
	}

	public Iterable<Ticket> getAllTickets() {
		return ticketBookingRepository.findAll();
	}

	public Ticket bookTicket(TicketRequest ticketRequest) {
		Ticket ticket = new Ticket();
		ticket.setAge(ticketRequest.getAge());
		ticket.setDestinationStation(ticketRequest.getDestinationStation());
		ticket.setEmail(ticketRequest.getEmail());
		ticket.setPassengerName(ticketRequest.getPassengerName());
		ticket.setPnr(ticketRequest.getPnr());
		ticket.setSourceStation(ticketRequest.getSourceStation());
		ticket.setTicketId(ticketRequest.getTicketId());
		ticket.setTrainName(ticket.getTrainName());
		ticket.setTrainNumber(ticketRequest.getTrainNumber());
		ticket.setSex(ticketRequest.getSex());
		ticket.setTrainName(ticketRequest.getTrainName());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime bookingTime = LocalDateTime.parse(ticketRequest.getBookingTime(), formatter);
		ticket.setBookingTime(bookingTime);
		ticket.setFare(ticketRequest.getFare());

		final LocalDate bookingDate = LocalDate.parse((ticketRequest.getBookingDate()));
		ticket.setBookingDate(bookingDate);

		return ticketBookingRepository.save(ticket);
	}

	public Ticket getAvailableTrains(TrainAvailabilityRequest request) {
		// fetch routes with from station and to station
		// hard code routes for now.
		Route route1 = new Route();
		Route route2 = new Route();

		return null;
	}

	public Station registerStation(com.example.demo.app.ticket.entity.Station station) {
		return stationRepository.save(station);
	}
}