package com.example.datastructures;

public class PrintInfinite {

	public static void main(String[] args) {
		int n = 7;
		printInfinites(12, 4);
	}

	public static void printInfinite(int n) {
		
		int[] aux = new int[n];
		printArray(aux);

		while (true) {
			printArray(aux);

			for (int i = 0; i < n; i++) {
				aux[i] = 0;
			}

			for (int i = 0; i < n; i++) {
				aux[i] = 1;
				printArray(aux);
				aux[i] = 0; // regain the array status
			}
		}
	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
	}
	/*
	 * 
	 * 4,2
	 * 
	 * 0000 1000 1100 0110 0011 0001 0000
	 * 
	 */

	//working well 
	public static void printInfinites(int n, int k) {
		int[] aux = new int[n];
		printArray(aux);
		
		while (true) {

			int i = 0;
			int j = 0;

			while (j < n) {

				if (j - i + 1 < k) {
					aux[j] = 1; // set
					j++;
					printArray(aux);

				}

				if (j - i + 1 == k) {
					aux[j] = 1; // set
					printArray(aux);
					aux[i] = 0; //unset

					i++;
					j++;
				}
			}
			printArray(aux);

			while (i < j) {
				aux[i] = 0; // reset the last bit
				i++;
				printArray(aux);
			}
		}
	}

}
