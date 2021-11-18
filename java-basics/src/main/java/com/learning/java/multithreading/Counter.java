package com.learning.java.multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private int count = 0;

	public void increment() {
		lock.writeLock().lock();

		try {
			count = count + 1;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int getCount() {
		try {
			lock.readLock().lock();
		} finally {
			lock.readLock().unlock();
		}
		return count;
	}
}
