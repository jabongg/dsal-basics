package com.learning.java.multithreading;

public class TicketCounter {

	private int availableSeats = 3;
	
	public void bookTicket(String passangerName, int numOfSeatsToBook) {
	
		notifyAll();
		
		if (availableSeats >= numOfSeatsToBook && numOfSeatsToBook > 0) {
			System.out.println("Hi " + passangerName + "! Your ticket is booked successfully...for " + numOfSeatsToBook + "seats.");
			
			availableSeats = availableSeats - numOfSeatsToBook;
			
		} else {
			System.out.println("Hi " + passangerName + "! seats are not available as per your demand." );
		}
	}
}
