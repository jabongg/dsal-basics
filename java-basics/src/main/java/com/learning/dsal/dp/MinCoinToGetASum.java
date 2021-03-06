package com.learning.dsal.dp;

public class MinCoinToGetASum {

	static int[][] table = new int[10][10];

	private static int getMinNumberOfCoins(int[] weight, int W, int n, int min) {

		// base condition
		if (W == 0) {
			return 1; // if sum is 0, do we have any way? yes.
		}

		if (n == 0) {
			return 0;
		}

		if (table[n][W] != -1) {
			return table[n][W];
		}
		if (weight[n - 1] <= W) {
			return table[n][W] =

					// in case last item i.e. weight[n - 1] is <bold>included</bold> in the knapsack
					Math.min(getMinNumberOfCoins(weight, W - weight[n - 1], n, min)

							,

							// in case last item i.e. weight[n - 1] is <bold>not included</bold> in the
							// knapsack
							getMinNumberOfCoins(weight, W, n - 1, min));
		}

		// in case item does not fit into capacity
		else if (weight[n - 1] > W) {
			return table[n][W] = getMinNumberOfCoins(weight, W, n - 1, min);
		}
		return 0;
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 1, 2, 5 };
		int sum = 7;
		int n = set.length;
		int min = Integer.MAX_VALUE - 1;

		// setting values to -1 to recognize the values
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table[i][j] = -1;
			}
		}
		System.out.println(getMinNumberOfCoins(set, sum, set.length, min));
	}

}
