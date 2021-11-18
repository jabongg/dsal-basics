package com.learning.site.geekforgeeks;

import java.util.Arrays;

/**
 * Given an array of random integer, find the maximum length of subsequence in
 * it such that the elements of subsequence are consecutive.
 * 
 * Example- input [25,1,26,2,27,3,29,28] 
 * Ans=5 (subsequence 25,26,27,29,28}
 * 
 * @author User
 *
 */
public class ConsecutiveSubsequence {

	public static void main(String[] args) {
		int[] input = {25,1,26,2,27,3,29,28};
		
		int maxLength = findMaxLengthConsecutiveSubsequence(input);
		System.out.println(maxLength);
	}

	private static int findMaxLengthConsecutiveSubsequence(int[] input) {
		Arrays.sort(input);
		
		int maxLength = 0;
		int currMax = 1;
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i + 1] == input[i] + 1) {
				currMax++;
				maxLength = Math.max(maxLength, currMax);
			} else {
				currMax = 1;
			}
		}
		return maxLength;
	}
}
