package com.learning.dsal.dp;

/**
 * Given an array, One needs to find the number of subsets with given difference
 * 
 * 
 * @author User
 *
 */
public class SubsetSumCountSubsetsWithGivenDifference {


	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static int countNumberOfSubsetsWithGivenSum(int set[], int n, int sum) {

		int[][] table = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				if (i == 0 || j == 0) {
					if (i == 0) {
						table[i][j] = 0; // initializing the row and column
					}
					
					if (j == 0) {
						table[i][j] = 1;
					}
				}
				
				// in case item weight is less than the capacity
				else if (set[i - 1] <= j) {
					table[i][j] = table[i - 1][j - set[i - 1]] // including the item
							+ table[i - 1][j];// excluding the item
				} else {

					// item is not included because of less capacity
					table[i][j] = table[i - 1][j];
				}
			}
		}

		return table[n][sum];
	}
	
	static int countNumberOfSubsetsWithGivenDifference(int set[], int n, int diff) {
		/*
		 * sum(S1) - sum(S2) = diff
		 * 
		 * sum(s1) + sum(S2) = sum(array)
		 * 
		 * ------------------
		 * 2 * sum(s1)     = sum(array) + diff
		 * 
		 * hence : sum(s1) = (sum(array) + diff) / 2
		 * 
		 */
		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}
		
		int sumS1 = (sum + diff ) / 2;
		int countSubset = countNumberOfSubsetsWithGivenSum(set, set.length, sumS1);
		
		return countSubset;
		
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = {1, 5, 2, 4, 6};
		int diff = 4;
		int n = set.length;
		System.out.println(countNumberOfSubsetsWithGivenDifference(set, n, diff));
	}
}
