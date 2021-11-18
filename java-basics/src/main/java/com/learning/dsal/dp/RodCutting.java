package com.learning.dsal.dp;

/**
 * unbounded knapsack example :Rod Cutting
 * 
 * length[] : {1, 2, 3, 4, 5, 6, 7, 8}; price[]: {1, 5, 8, 9, 10, 17, 17, 20};
 * rodLength : 4
 * 
 * task: maximize the profit
 * 
 * @author User
 *
 */
public class RodCutting {

	public static void main(String[] args) {
		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int rodLength = 4;

		System.out.println(rodCut(price, rodLength));
		System.out.println(maximizeProfit(length, price, rodLength));

	}

	private static int maximizeProfit(int[] length, int[] price, int rodLength) {
		return knapsackUnbounded(length, price, rodLength, length.length);
	}

	private static int knapsackUnbounded(int[] weight, int[] value, int W, int n) {

		// base condition
		if (W == 0 || n == 0) {
			return 0;
		}

		if (weight[n - 1] <= W) {
			return Math.max(

					// in case last item i.e. weight[n - 1] is <bold>included</bold> in the knapsack
					value[n - 1] + knapsackUnbounded(weight, value, W - weight[n - 1], n),

					// in case last item i.e. weight[n - 1] is <bold>not included</bold> in the
					// knapsack
					knapsackUnbounded(weight, value, W, n - 1));
		}

		// in case item does not fit into capacity
		else if (weight[n - 1] > W) {
			return knapsackUnbounded(weight, value, W, n - 1);
		}
		return 0;
	}

	private static int rodCut(int[] price, int n) {
		// base case
		if (n == 0) 
			return 0;
		int maxValue = Integer.MIN_VALUE;
		// one by one partition the given rod of length n 
		// into two of length (1, n-1), (2, n-2), (3, n-3) ...
		// and take the maximum
		
		for (int i = 1; i <= n; i++) {
			// rod of length i has cost of price[i-1]
			int cost = price[i-1] + rodCut(price, n - 1);
			if (cost > maxValue) {
				maxValue = cost;
			}
		}
		return maxValue;
	}
}
