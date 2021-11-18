package com.learning.java.multithreading;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {

	private Queue<Integer> sharedQueue;
	private  final int queueSize = 5;
	public Producer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run() {

		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.size() == 5) {
					System.out.println("producer is waiting for consumer to consume");
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Random random = new Random();
				int data = random.nextInt(5);
				sharedQueue.add(data);
				
				System.out.println("data produced" + data);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
				sharedQueue.notify();
			}
		}
		
	}
}
