package com.learning.java;

public interface Stack<T> {

	void push();
	T pop();
	T peek();
	boolean isEmpty();
	boolean isFull();
	
}
