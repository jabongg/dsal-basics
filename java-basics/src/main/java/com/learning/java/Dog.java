package com.learning.java;

public class Dog extends Animal {

	int speed = 30;
	
	public void bark() {
		System.out.println("bhon! bhon!");
	}

	public static Dog walk() {
		System.out.println("dog walking");
		return null;
	}

	public void makeNoise() {
		System.out.println("bhon! bhon!");
	}
}
