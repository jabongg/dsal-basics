package com.learning.java.multithreading;

import java.util.Queue;

public class Consumer implements Runnable {

	private Queue<Integer> sharedQueue;

	public Consumer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					System.out.println("Consumed all data. Now, Consumer is waiting for item to be produced.");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				int data = sharedQueue.poll();
				System.out.println("data consumed " + data);
				sharedQueue.notify();
			}
		}
	}

}
