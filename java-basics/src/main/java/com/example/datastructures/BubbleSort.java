package com.example.datastructures;

public class BubbleSort {

	public static void main(String[] args) {
		int[] A = {13, 2, 5, 1, 29, 8, 7, 6, 14};
		PrintUtil.printArray(A);		
		bubbleSort(A);
		
		System.out.println();
		PrintUtil.printArray(A);
	}

	/*
	 * bubble sort algorithm
	 */
	private static int[] bubbleSort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					// swap A[i] with A[j]
					int temp = A[j];
					A[j] = A[i];
					A[i] = temp;
				}
			}
		}
		return A;
	}

}
