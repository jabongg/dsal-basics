package com.learning.java.stack.recursion;

public class FactorialUsingRecursion {

	public static void main(String[] args) {
		System.out.println(factorial(7));
	}

	private static int factorial(int n) {
		
		//base condition
		if (n == 1 || n == 0) {
			return 1;
		}
		
		return n * factorial(n - 1);
		
	}
}
