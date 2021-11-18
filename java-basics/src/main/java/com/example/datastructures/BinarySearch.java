package com.example.datastructures;

public class BinarySearch {

	public static void main(String[] args) {
		int[] A = {2, 5, 7, 16, 34, 38, 99, 100};
		int index = binarySearch(A, 16);

		System.out.println(index);
		
		int index2 = binarySearch(A, 26); 

		System.out.println(index2);
	}

	private static int binarySearch(int[] A, int key) {
		int start = 0;
		int end = A.length - 1;
		
		
		while (start < end) {
			int mid = start + ((end - start) / 2);

			if (A[mid] == key) {
				return mid;
			} else if ( key < A[mid]) {
				end = mid - 1;
			} else if (key > A[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}
}
