package com.learning.dsal.heap;

public class SumBtwnK1nK2 {


	public static void main(String[] args) {
		int[] A = {1, 3, 12, 5, 15, 11};
		int k1 = 3;
		int k2 = 6;
		
		System.out.println(calculateSumBtwnK1nK2(A, k1, k2));
	}

	
	// calculate sum between given two minimum elements
	private static int calculateSumBtwnK1nK2(int A[], int k1, int k2) {
		int element_k1 = Heap.getKthSmallestElement(A, k1);
		int element_k2 = Heap.getKthSmallestElement(A, k2);
		
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if ((A[i] > element_k1) && (A[i] < element_k2)) {
				sum += A[i];
			}
		}
		return sum;
		
	}
}
