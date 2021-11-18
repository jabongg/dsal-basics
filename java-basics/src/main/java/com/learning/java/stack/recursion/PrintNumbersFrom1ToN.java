package com.learning.java.stack.recursion;

/** 
 * print numbers from 1 to n
 * @author User
 *
 */
public class PrintNumbersFrom1ToN {

	 public static void main(String[] args) {
		int N = 7;
		
		print(N);
		
	}

	private static void print(int n) {

		// Base condtion : smallest valid input
		if (n == 1) {
			System.out.print(n + " "); 
			return;
		}
		// hypothesis
		// induction
		System.out.print(n);
		print(n - 1);

	}
}
