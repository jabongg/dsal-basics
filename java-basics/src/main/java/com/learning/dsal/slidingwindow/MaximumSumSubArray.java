package com.learning.dsal.slidingwindow;

/**
 * Problem statement : Given an array of integers A[] and a sliding window K.
 * Output : return the subarray with maximum sum i.e. the range
 * 
 * @author User
 *
 */
public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] A = { 1, 3, 11, -3, 15, 8, 6, -7 };
		int k = 4;// slidingWindow
		int output = findMaximumSumSubArray(A, k);

		System.out.print(output + " ");		
		System.out.println(maximumSum(A, k));
	}

	private static int findMaximumSumSubArray(int[] A, int k) {
		int i = 0;
		int j = 0;

		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		while (j - i + 1 < k) {
			sum = sum + A[j];
			j++;
		}

		// main loop
		while (j < A.length) {
			if (j - i + 1 == k) {
				sum = sum + A[j];

				if (maxSum < sum) {
					maxSum = sum;
					System.out.println("i=" + (i) + " j=" + (j));

				}
			}

			// now, slide the window k
			sum = sum - A[i];
			i++;
			j++;
		}

		return maxSum;
	}
	
	
	public static int maximumSum(int[] A, int k) {
		
		int maximumSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < A.length - (k - 2); i++) {
			int sum = 0;

			for (int j = i; j < i + (k - 1); j++) {
				sum = A[j] + sum;
			}
			
			if (maximumSum < sum) {
				maximumSum = sum;
			}
		}
		
		return maximumSum;
	}
}
