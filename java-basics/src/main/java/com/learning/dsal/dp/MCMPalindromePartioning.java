package com.learning.dsal.dp;

public class MCMPalindromePartioning {

	static int[][] t = new int[20][20]; // suppose constraint in the problem is 1000

	public static void main(String[] args) {

		// initialize the table with -1
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}

		String sampleString = "tittin";

		// find minimum cost to multiply the matrices
		int minimumCost = findMinimumCostOfMatrixMultiplication(sampleString);
		System.out.println(minimumCost);
	}

	private static int findMinimumCostOfMatrixMultiplication(String s) {

		/*
		 * Find : 1. i and j 2. base condition 3. make scheme to move for k
		 */

		// initialize : point 1 completed
		int i = 0;
		int j = s.length() - 1;

		return solve(s, i, j);
	}

	private static int solve(String s, int i, int j) {

		// base condition : point 2 covered
		if (i >= j)
			return 0; // number of partitions we have to do if size is 0 or 1.

		if (isPalindrome(s, i, j))
			return 0;

		int minimumCost = Integer.MAX_VALUE;

		// decide scheme to move k -> i to k; and k + 1 to j; point 3 covered
		for (int k = i; k <= j - 1; k++) {

			int tempAnswer = solve(s, i, k) + solve(s, k + 1, j) + 1; // for operation on results of two sub parts.
			if (tempAnswer < minimumCost) {
				minimumCost = tempAnswer;
			}
		}
		return t[i][j] = minimumCost;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		if (i == j)
			return true; // single character
		if (i > j)
			return true; // empty string
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
