package com.learning.java.multithreading;

public class TicketBookingThread extends Thread {

	private TicketCounter counter;
	private String passangerName;
	private int numOfSeatsToBook;


	public TicketBookingThread(TicketCounter counter, String passangerName, int numOfSeatsToBook) {
		super();
		this.counter = counter;
		this.passangerName = passangerName;
		this.numOfSeatsToBook = numOfSeatsToBook;
	}


	@Override
	public void run() {
		counter.bookTicket(passangerName, numOfSeatsToBook);
	}

	
}
