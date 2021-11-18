package com.learning.dsal.searching;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Peak Element : An element whose neighbors are smaller. Edge case : for first
 * and last element, if these elements are greater than their only neighbor,
 * consider it as a peak element 10, |30|, 12, |15|, 9, 4, 3, 5, 6, 11, 20,
 * |43|, 10, 1, |11|
 * 
 * peak elements are 30 15 43 11
 * 
 * @author User
 *
 */
public class PeakElement {

	public static void main(String[] args) {
		int[] A = {45, 30, 12, 15, 9, 4, 3, 5, 6, 11, 20, 43, 10, 1, 11 };

		ArrayList<Integer> peaks = findPeakElement(A);

		HashSet<Integer> peaksSet = new HashSet<>();
		peaksSet.addAll(peaks);

		for (Integer peak : peaksSet) {
			System.out.print(peak + " ");
		}
	}

	private static ArrayList<Integer> findPeakElement(int[] A) {
		ArrayList<Integer> peaks = new ArrayList<>();

		for (int i = 1; i < A.length - 2; i++) {
			for (int j = i + 1; j < A.length - 2; j++) {
				int start = i;
				int end = j;
				while (start <= end) {
					int mid = start + (end - start) / 2;

					// considering all elements except the first and the last elements.

					if (mid > 0 && mid < A.length - 1) {
						if ((A[mid] > A[mid - 1]) && (A[mid] > A[mid + 1])) {
							peaks.add(A[mid]);
							break;
							// return A[mid];
						}

						// if peak A[mid - 1] > A[mid] then peak lies in left, set end = mid - 1;
						if (A[mid - 1] > A[mid]) {
							end = mid - 1;
						} else if (A[mid + 1] > A[mid]) {
							start = mid + 1;
						}
					}

				}
			}
		}

		// handling boundary conditions
		if (A[0] > A[1]) {
			peaks.add(A[0]);
		} 
		
		if (A[A.length - 1] > A[A.length - 2]) {
			peaks.add(A[A.length - 1]);
		}
		return peaks;

	}

}
