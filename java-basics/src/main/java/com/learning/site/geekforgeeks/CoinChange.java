package com.learning.site.geekforgeeks;

import java.util.*;

public class CoinChange {

/*
4
5 10 2 1
52

*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] denominations = new int[n];
		for (int i = 0; i < n; i++) {
			denominations[i] = scan.nextInt();
		}

		int sum = scan.nextInt();
		int coins = findMinCoins(denominations, sum);
		System.out.println(coins);
	}

	
	public static int findMinCoins(int[] denominations, int sum) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for (int coin : denominations) {
			heap.add(coin);
		}
		
		//System.out.println(heap);
		
		int coins = 0;
		while (sum != 0 && !heap.isEmpty()) {
			int maxValue = 0;
			
			maxValue = heap.peek();
			
			//System.out.println(maxValue);
			
			while (sum >= maxValue) {
				sum = sum - maxValue;
				coins++;
			}
			heap.remove();
		}
		
		return coins;
	}
}