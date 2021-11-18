package com.learning.java.multithreading;

public class Account {
	volatile private int balance = 6000;
	//balance = 6000;
	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
