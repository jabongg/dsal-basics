package com.learning.java;

public class Animal implements Cloneable {

	int speed = 50; //kmph
	public static void main(String[] args) throws CloneNotSupportedException {
		Animal a = new Animal();
		Animal b = (Animal) a.clone();
		Animal c = a;
		System.out.println(a + " " + b);
		System.out.println(a + " " + c);

		try {
			a.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static Animal walk() {
		System.out.println("Animal walking");
		return null;
	}
	public void makeNoise() {
		System.out.println("Animal making noise");
	}
	
}
