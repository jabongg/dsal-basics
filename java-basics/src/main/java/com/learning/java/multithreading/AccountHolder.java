package com.learning.java.multithreading;

public class AccountHolder implements Runnable {

	private Account account;

	public AccountHolder(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 4; i++) {
			makeWithdrawal(2000);
			if (account.getBalance() < 0) {
				System.out.println("Amount overdrawn");
			}
		}
	}

	synchronized private void makeWithdrawal(int withdrawAmount) {

		if (account.getBalance() >= withdrawAmount) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw money " + withdrawAmount);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			account.withdraw(withdrawAmount);

			System.out.println(Thread.currentThread().getName() + " completed transaction. Remaining amount is : "
					+ account.getBalance());

		} else {
			System.out.println("not enough money to withdraw the amount. Not enough money for : "
					+ Thread.currentThread().getName() + " current balance is : " + account.getBalance());
		}
	}
}
