package com.learning.dsal.dp;

public class KnapsackMemoized {

	static int[][] table = new int[10][10];
	
	
	public static void main(String[] args) {
		
		// setting values to -1 to recognize the values
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table[i][j] = -1;
			}
		}
		
		// given weights of n items.
		int[] weight = {1, 3, 4, 5}; // weight of items
		int[] value = {1, 4, 5, 7}; // price of the items
		int W = 7; // capacity of the knapsack
		

		
		
		// functions starts here.
		int maxValue = knapsack(weight, value, W, weight.length);
		System.out.println(maxValue);
	}

	private static int knapsack(int[] weight, int[] value, int W, int n) {

		// base condition
		if (W == 0 || n == 0) {
			return 0;
		}
		
		if (table[n][W] != -1) {
			return table[n][W];
		}
		if (weight[n - 1] <= W) {
		return	table[n][W] = Math.max(
				
				// in case last item i.e. weight[n - 1] is <bold>included</bold> in the knapsack
				value[n - 1] + knapsack(weight, value, W - weight[n - 1], n - 1),
				
				// in case last item i.e. weight[n - 1] is <bold>not included</bold> in the knapsack
				knapsack(weight, value, W, n - 1));				
		}
		
		// in case item does not fit into capacity
		else if (weight[n - 1] > W) {
			return table[n][W] = knapsack(weight, value, W, n - 1);				
		}
		return 0;
	}
}
