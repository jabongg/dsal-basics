package com.learning.site.geekforgeeks;

public class MinimumOptimumOperation {

	public static void main(String[] args) {
		int n = 8;
		System.out.println(minOperation(n));
	}

	public static int minOperation(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 2 == 0)
				n = n / 2;
			else
				n -= 1;

			count++;
		}
		return count;
	}
}
