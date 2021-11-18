package com.learning.dsal.slidingwindow;

public class FirstNegativeNumberInASubArray {
	public static void main(String[] args) {
		int[] A = {1, 3, -1, -3, 5, 3, 6, -7};
		int k = 3;// slidingWindow
		findFirstNegativeNumberInASubArray(A, k);
	}

	private static void findFirstNegativeNumberInASubArray(int[] A, int k) {
		int i = 0;
		int j = i + k - 1;
		int p = 0; // current window cursor.
		
		// O(n2) solution : Brute force solution
		while (j < A.length) {
			for ( p = i; p <= j; p++) { // Repetitive work is done here.... in 
				if (A[p] < 0) {
					System.out.print(A[p] + " ");
					break;
				}
			}
			i++; j++; // sliding the window here.

		}
	}

}
