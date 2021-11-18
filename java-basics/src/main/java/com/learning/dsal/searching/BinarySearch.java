package com.learning.dsal.searching;

/**
 * In a given sorted array, find a given element.
 * @author User
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] A = {10, 17, 39, 40, 60, 83, 92, 99 };
		int element = 92;
		
		int index = binarySearch(A, element);
		if (index == -1) 
			System.out.println("Element not present!");
		System.out.println("elmenent is present at index : " + index);
		
	}

	private static int binarySearch(int[] A, int element) {
		int start = 0;
		int end = A.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				return mid;
			} else if (element < A[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
