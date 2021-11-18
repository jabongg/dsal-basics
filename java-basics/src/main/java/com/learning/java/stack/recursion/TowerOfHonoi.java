package com.learning.java.stack.recursion;

public class TowerOfHonoi {

	static int count = 1;
	public static void main(String[] args) {
		move(2, "A", "B", "C");
	}

	private static void move(int n, String start, String temp, String end) {

		if (n == 1) {
			System.out.println(count + " Move disk from " + start + " to " + end);
			count++;
		} else {
			move(n - 1, start, end, temp);
			System.out.println(count + " Move " + start + " to " + end);
			count++;
			move(n - 1, temp, start, end);
		}		
	}
}
