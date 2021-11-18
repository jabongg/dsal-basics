package com.learning.java;

public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Animal e = new Animal();
		
		Animal a = new Dog();
		Animal b = new Cat();
		Cat c = new Cat();
		Dog d = new Dog();
		
		/*
		 * a.walk(); b.walk(); c.walk(); d.walk(); e.walk();
		 */
		c.makeNoise();
		
		/*
		 * System.out.println(a.speed); System.out.println(b.speed);
		 * System.out.println(c.speed); System.out.println(d.speed);
		 * System.out.println(e.speed);
		 */
		
	}
}
