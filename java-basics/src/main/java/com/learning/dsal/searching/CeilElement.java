package com.learning.dsal.searching;

public class CeilElement {

	public static void main(String[] args) {
		int[] A = {10, 17, 39, 40, 60, 83, 92, 99 };
		int element = 33;
		
		int ceilElementIndex = findCeilElement(A, element);
		System.out.println("floor elmenent is present at index : " + ceilElementIndex + " and is :" + A[ceilElementIndex]);
		
	}

	private static int findCeilElement(int[] A, int element) {
		int start = 0;
		int end = A.length - 1;
		int ceilElementIndex = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				return mid;
			} else if (A[mid] > element) {
				ceilElementIndex = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ceilElementIndex;
	}
	

}
