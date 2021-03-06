package com.learning.dsal.dp;

public class SubsetSumMemoized {


/**
 * Subset Sum Problem | DP-25
Last Updated: 09-11-2020
 
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

Example: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.


 * @author User
 *
 */
	//A memoized solution for subset sum

	static boolean table[][] = new boolean[10][30];

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[],
							int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return table[n][sum] =isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained 
		by any of the following
			(a) including the last element
			(b) excluding the last element */
			boolean isIncluded = isSubsetSum(set, n - 1, sum - set[n - 1]);
			boolean notIncluded = isSubsetSum(set, n - 1, sum); 
			
			if (isIncluded || notIncluded) {
				System.out.println("table " + (n - 1) + " " + sum + " is true");
			}
			return table[n][sum] = isIncluded || notIncluded;
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2};
		int sum = 16;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset"
							+ " with given sum");
		else
			System.out.println("No subset with"
							+ " given sum");
	}
	
}