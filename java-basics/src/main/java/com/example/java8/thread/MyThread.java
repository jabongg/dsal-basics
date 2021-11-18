package com.example.java8.thread;

public class MyThread extends Thread {
	public static void main(String[] args) {
		
		
		MyThread t = new MyThread();
		Boolean result = t.equals(null);
		System.out.println(result);
		
		t.start();
	}

	public void run() {
		System.out.println("Thread is running");
	}
}
