package com.example.datastructures;

public class InsertionSort {
	
	public static void main(String[] args) {

		int[] A = {13, 2, 5, 1, 29, 8, 7, 6, 14};
		
		//@SuppressWarnings({"unchecked", "deprecation"})
		PrintUtil.printArray(A);		
		insertionSort(A);
		
		System.out.println();
		PrintUtil.printArray(A);
	
	}

	private static void insertionSort(int[] A) {
		
		int j = 1;
		int i = 0;	
		
		while (j < A.length) {
			int key = A[j];
			i = j - 1;
			
			while (i > -1 && key < A[i]) {
				A[i + 1] = A[i];
				i--;
			}
			
			A[i + 1] = key;			
			j++;
		}
		 
	}
}
