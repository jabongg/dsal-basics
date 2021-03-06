package com.learning.dsal.slidingwindow;

/**
 * Problem statement : Given an array of integers A[] and a sliding window K.
 * Output : return an array of highest element from each subarray.
 * @author User
 *
 */
public class HighestElementSubarray {

	public static void main(String[] args) {
		int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;// slidingWindow
		int[] output = findHighestElementSubArray(A, k);
		
		for (int i = 0; i < output.length; i++)
			System.out.print(output[i] + " ");
	}

	private static int[] findHighestElementSubArray(int[] A, int k) {
		int[] highestElements = new int[A.length - k + 1];
		int j = 0;
		
		for (int i = 0; i < A.length - k + 1; i++) {
			highestElements[j++] =findMaxElement(A[i], A[i + 1], A[i + 2]);;
		}
		
		return highestElements;
	}
	
	private static int findMaxElement(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		}
		
		if (c >= a && c >= b) {
			return c;
		}
		
		if (b >= a && b >= c) {
			return b;
		}
		return c;
	}
}
