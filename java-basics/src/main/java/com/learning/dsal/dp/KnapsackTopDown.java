package com.learning.dsal.dp;

public class KnapsackTopDown {

	public static void main(String[] args) {

		// given weights of n items.
		int[] weight = {1, 3, 4, 5}; // weight of items
		int[] value = {1, 4 , 5, 7}; // price of the items
		int W = 7; // capacity of the knapsack

		// functions starts here.
		int maxValue = knapsackTopDown(weight, value, W, weight.length);
		System.out.println(maxValue);
	}

	private static int knapsackTopDown(int[] weight, int[] value, int W, int n) {

		int[][] table = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {

				if (i == 0 || j == 0) {
					table[i][j] = 0; // initializing the row and column
				}

				// in case item weight is less than the capacity
				else if (weight[i - 1] <= j) {
					table[i][j] = Math.max(

							// including the item
							value[i - 1] + table[i - 1][j- weight[i - 1]],

							table[i - 1][j]);
				} else {

					// item is not included because of less capacity
					table[i][j] = table[i - 1][j];
				}

			}
		}
		 
		return table[n][W];
	}
}
