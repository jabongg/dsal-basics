package com.learning.dsal.searching;

/**
 * Given an element, find the largest element lesser than the given element.
 * @author User
 *
 */
public class FloorElement {

	public static void main(String[] args) {
		int[] A = {10, 17, 39, 40, 60, 83, 92, 99 };
		int element = 84;
		
		int floorElementindex = findFloorElement(A, element);
		System.out.println("floor elmenent is present at index : " + floorElementindex + " and is :" + A[floorElementindex]);
		
	}

	private static int findFloorElement(int[] A, int element) {
		int start = 0;
		int end = A.length - 1;
		int floorElementIndex = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				return mid;
			} else if (element > A[mid]) {
				floorElementIndex = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return floorElementIndex;
	}

}
