package com.learning.java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Client {

	public static void main(String[] args) {
		Callable<String> task = () -> "my task is done";
		Callable<Integer> getSomeOfEvenNumbers = () -> {
			int sum = 0;

			for (int i = 1; i <= 10; i++) {

				if (i % 2 == 0) {
					sum = sum + i;
				}
			}
			return sum;

		};

		Callable<Integer> getSomeOfOddNumbers = () -> {
			int sum = 0;

			for (int i = 1; i <= 10; i++) {

				if (i % 2 == 1) {
					sum = sum + i;
				}
			}
			return sum;

		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<String> future1 = executorService.submit(task);
		Future<Integer> future2 = executorService.submit(getSomeOfEvenNumbers);
		Future<Integer> future3 = executorService.submit(getSomeOfOddNumbers);
		
		try {
			System.out.println(future1.get());
			System.out.println("even numbers sum :" + future2.get());
			try {
				System.out.println("odd numbers sum :" + future3.get(5, TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}
}
