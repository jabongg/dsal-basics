package com.learning.dsal.dp;

public class MCMMemoized {
	
	static int[][] t = new int[5][5]; // suppose constraint in the problem is 1000

	public static void main(String[] args) {
		
		// initialize the table with -1
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		int[] A = {10, 20, 30} ;//{40, 20, 30, 10, 30};

		// find minimum cost to multiply the matrices
		int minimumCost = findMinimumCostOfMatrixMultiplication(A);
		System.out.println(minimumCost);
	}

	private static int findMinimumCostOfMatrixMultiplication(int[] A) {

		/*
		 * Find : 
		 * 1. i and j
		 * 2. base condition
		 * 3. make scheme to move for k
		 */
		
		//  initialize : point 1 completed
		int i = 1;
		int j = A.length - 1;
		
		return solve(A, i, j);
	}

	private static int solve(int[] A, int i, int j) {

		// base condition : point 2 covered
		if (i >= j) 
			return 0;
		
		if (t[i][j] != -1) {
			return t[i][j];
		}

		int minimumCost = Integer.MAX_VALUE;
		
		// decide scheme to move k ->  i to k; and k + 1 to j; point 3 covered
		for (int k = i; k <= j - 1; k++) {
		
			int tempAnswer = solve(A, i, k) + solve(A, k + 1, j) + A[i - 1] * A[k] * A[j];
			if (tempAnswer < minimumCost) {
				minimumCost = tempAnswer;
			}
		}
		return t[i][j] = minimumCost;
	}
}
