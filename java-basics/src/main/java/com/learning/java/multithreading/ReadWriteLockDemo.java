package com.learning.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLockDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		final Counter counter = new Counter();
		Runnable task1 =  new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "writing on the count variable");
				for (int i = 1; i <= 50; i++) {
					counter.increment();
					System.out.println(counter.getCount());
				}
			}
		};
		
		executorService.submit(task1);
		executorService.shutdown();
	}
}
