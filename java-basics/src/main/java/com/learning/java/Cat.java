package com.learning.java;

public class Cat extends Animal {

	int speed = 20;
	public void meow() {
		System.out.println("meow!");
	}
	
	public static Cat walk() {
		System.out.println("cat walking");
		return null;
	}

	public void makeNoise() {
		System.out.println(super.speed);
		System.out.println(speed);
		System.out.println("meow");
	}

}
