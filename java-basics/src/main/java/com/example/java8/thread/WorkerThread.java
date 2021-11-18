package com.example.java8.thread;

public class WorkerThread implements Runnable {

	private String message;

	public WorkerThread(String message) {
		super();
		this.message = message;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() +" starting!" + message);
		//processMessage();
		//System.out.println(Thread.currentThread().getName() + "ending!");
	}

	private void processMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
