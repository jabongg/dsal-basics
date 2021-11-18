package com.learning.java.stack.recursion;

public class Fibonacci {
 
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
	}

	private static int fibonacci(int n) {
		
		// base condition 
		if (n == 1 || n == 2)  {
			//System.out.print(n + " ");
			return 1;
		}
		
		int fN_2 = fibonacci(n - 2); 
		int fN_1 = fibonacci(n - 1);
		int value = fN_1 + fN_2;
		//int value =  fibonacci(n - 2) + fibonacci(n - 1);
		//System.out.print(value + " ");
		return value;
	}
}
