package com.learning.dsal.dp;

public class SubsetSumMinimumSubsetSumDifference {
	// working 
	
	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean[][] minimumSubsetSumDifference(int set[], int n, int sum) {
		boolean[][] table = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				if (i == 0 || j == 0) {
					if (i == 0) {
						table[i][j] = false; // initializing the row and column
					}
					
					if (j == 0) {
						table[i][j] = true;
					}
				}
				
				// in case item weight is less than the capacity
				else if (set[i - 1] <= j) {
					table[i][j] = table[i - 1][j - set[i - 1]] // including the item
							|| table[i - 1][j];// excluding the item
				} else {
					// item is not included because of less capacity
					table[i][j] = table[i - 1][j];
				}
			}
		}
		return table;
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = {1, 6, 11, 5};
		int sum = 0;
		
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}
		
		int n = set.length;
		boolean[][] t = minimumSubsetSumDifference(set, n, sum);
		
		boolean[] lastRowMatrix = new boolean[t[0].length];
		
		for (int j = 0; j < t[0].length; j++) {
			lastRowMatrix[j] = t[t.length - 1][j];
		}
		
		int[] trueValues = new int[lastRowMatrix.length];
		int k = 0;
		
		for (int i = 0; i < lastRowMatrix.length / 2; i++) {
			if (lastRowMatrix[i]) {
				trueValues[k++] = i; // sum
			}
		}
	
		int minimum = Integer.MAX_VALUE;
		
		for (int i = 0; i < trueValues.length; i++) {
			minimum = Math.min(minimum, sum - 2 * trueValues[i]);
		}
		
		System.out.println(minimum);
	}
}