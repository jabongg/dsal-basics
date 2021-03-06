package com.learning.dsal.dp;

/**
 * find maximum number of ways to gain a given sum
 * from array of coins
 * @author User
 *
 */
public class CoinChangeMaxWays {

	static int[][] table = new int[10][10];

	private static int getMaxNumberOfWaysForCoinChange(int[] weight, int W, int n) {

		// base condition
		if (W == 0 ) {
			return 1; // if sum is 0, do we have any way? yes.
		} 
		
		if ( n == 0) {
			return 0;
		}
		
		if (table[n][W] != -1) {
			return table[n][W];
		}
		if (weight[n - 1] <= W) {
		return	table[n][W] = 
				
				// in case last item i.e. weight[n - 1] is <bold>included</bold> in the knapsack
				getMaxNumberOfWaysForCoinChange(weight, W - weight[n - 1], n)
				
				+ 
				
				// in case last item i.e. weight[n - 1] is <bold>not included</bold> in the knapsack
				getMaxNumberOfWaysForCoinChange(weight, W, n - 1);				
		}
		
		// in case item does not fit into capacity
		else if (weight[n - 1] > W) {
			return table[n][W] = getMaxNumberOfWaysForCoinChange(weight, W, n - 1);				
		}
		return 0;
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 1, 2, 5};
		int sum = 7;
		int n = set.length;
		
		
		// setting values to -1 to recognize the values
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table[i][j] = -1;
			}
		}		
		System.out.println(getMaxNumberOfWaysForCoinChange(set, sum, set.length));
	}
	
}
