package com.learning.dsal.dp;

// to find: number of subsets present in array with given sum
public class SubsetSumCountOfSubsets {


	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static int isSubsetSumTopDown(int set[], int n, int sum) {

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

	/* Driver code */
	public static void main(String args[]) {
		int set[] = {5, 6, 8, 10};
		int sum = 11;
		int n = set.length;
		System.out.println(isSubsetSumTopDown(set, n, sum));
	}

}