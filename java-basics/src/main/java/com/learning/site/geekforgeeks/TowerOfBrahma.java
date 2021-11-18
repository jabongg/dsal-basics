package com.learning.site.geekforgeeks;

public class TowerOfBrahma {
	public static long towerOfBrahma(int n, int swarglok, int paataallok, int mrityulok) {
		// Your code here

		if (n == 1) {
			System.out.println("move disk " + n + " from pillar " + swarglok + " to pillar " + paataallok);
			return 1;
		}

		towerOfBrahma(n - 1, swarglok, mrityulok, paataallok);
		System.out.println("move disk " + n + " from pillar " + swarglok + " to pillar " + paataallok);
		towerOfBrahma(n - 1, mrityulok, paataallok, swarglok);

		return (long) (Math.pow(2, n) - 1);
	}

	public static void main(String[] args) {
		System.out.println(towerOfBrahma(3 , 1, 3, 2));
	}
}
