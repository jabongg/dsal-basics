package com.learning.dsal.dp;

public class SubsetSumEqualSumPartition {

	// A memoized solution for subset sum

	static boolean table[][] = new boolean[10][30];

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {

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

		return table[n][sum];
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 2, 3, 4, 6};
		// int sum = 15;
		int n = set.length;
		if (isEqualSumPartion(set, n) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}

	private static boolean isEqualSumPartion(int[] set, int n) {

		int partitionSum = 0;

		for (int i = 0; i < set.length; i++) {
			partitionSum = partitionSum + set[i];
		}

		if (partitionSum % 2 != 0) {
			return false;
		}

		return isSubsetSum(set, set.length, partitionSum / 2);
	}

}