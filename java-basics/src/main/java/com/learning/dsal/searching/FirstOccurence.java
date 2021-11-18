package com.learning.dsal.searching;

/**
 * Given a non decreasing array : find the first occurence of a given element
 * @author User
 *
 */
public class FirstOccurence {

	public static void main(String[] args) {
		int[] A = {10, 17, 39, 40, 40, 40, 40, 60, 83, 92, 99};
		int element = 40;
		
		int indexFirstOccurrence = binarySearchFirstOccurrence(A, element);
		int indexLastOccurrence = binarySearchLastOccurrence(A, element);

		if (indexLastOccurrence == -1 ||indexFirstOccurrence == -1) 
			System.out.println("Element not present!");
		System.out.println("indexFirstOccurrence : " + indexFirstOccurrence);
		System.out.println("indexLastOccurrence : " + indexLastOccurrence);

		System.out.println("Count of given number :" + ((indexLastOccurrence - indexFirstOccurrence) + 1) );
	}

	// first occurrence of an element 
	private static int binarySearchFirstOccurrence(int[] A, int element) {
		int start = 0;
		int end = A.length - 1;
		
		int firstOccurenceIndex = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				firstOccurenceIndex = mid;
				end = mid - 1;
			} else if (element < A[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return firstOccurenceIndex;
	}

	// last occurrence of an element 
	private static int binarySearchLastOccurrence(int[] A, int element) {
		int start = 0;
		int end = A.length - 1;
		
		int lastOccurenceIndex = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				lastOccurenceIndex = mid;
				start = mid + 1;
			} else if (element < A[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return lastOccurenceIndex;
	}
}
