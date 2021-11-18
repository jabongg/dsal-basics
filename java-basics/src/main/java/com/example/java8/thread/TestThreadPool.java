package com.example.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
 
	public static void main(String[] args) {
		// creating thread using executors service
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread(" " + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			System.out.println("executing");
		}
		System.out.println("finished all threads.");
	}
}
