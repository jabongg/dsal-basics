package com.learning.java.multithreading;

public class TicketBooking {

	public static void main(String[] args) {
		TicketCounter counter = new TicketCounter();
		TicketBookingThread t1 = new TicketBookingThread(counter, "John", 2);
		TicketBookingThread t2 = new TicketBookingThread(counter, "Martin", 2);
		
		t1.start();
		t2.start();
	}
}
