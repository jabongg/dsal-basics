package com.learning.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<>();
		
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
		
		Thread t1 = new Thread(producer, "producer");
		Thread t2 = new Thread(consumer, "consumer");
		
		t1.start();
		t2.start();
		
	}
}
