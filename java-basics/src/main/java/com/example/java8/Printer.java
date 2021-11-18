package com.example.java8;

public interface Printer {

	default void print() {
		System.out.println("I am a printer!");
	}
	
	static void printPdfs() {}
}
