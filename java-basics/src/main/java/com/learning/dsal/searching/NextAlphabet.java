package com.learning.dsal.searching;

/**
 * Given an array of characters, and a given character for which we have to find just greater number.
 * a b d f h 
 * given character : f 
 * Ans: h
 * @author User
 *
 */
public class NextAlphabet {


	public static void main(String[] args) {
		char[] A = {'a', 'b', 'd', 'f', 'h'};
		char element = 'f';
		
		int ceilElementIndex = findNextAlphabet(A, element);
		System.out.println("elmenent is present at index : " + ceilElementIndex);
		
	}

	private static int findNextAlphabet(char[] A, char element) {
		int start = 0;
		int end = A.length - 1;
		int ceilElementIndex = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2 ;

			if (element == A[mid]) {
				start = mid + 1;
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
