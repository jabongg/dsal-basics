package com.learning.java.array;

import java.util.ArrayList;
import java.util.List;

import com.example.datastructures.PrintUtil;

public class SegragateZeroOne {

	// Input array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
	// Output array = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 };

		segregateZerosAndOne(A);
		System.out.println();
		seggreateZerosAndOnes(A);
		System.out.println();
		segregate0and1(A);
	}

	private static void segregateZerosAndOne(int[] A) {

		List<Integer> al = new ArrayList<>();
		// order is important
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				al.add(A[i]);
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				al.add(A[i]);
			}
		}
		// solution using arraylist
		int[] B = new int[A.length];

		// ArrayList to Array Conversion
		for (int i = 0; i < al.size(); i++)
			B[i] = al.get(i);

		PrintUtil.printArray(B);
	}

	private static void seggreateZerosAndOnes(int[] A) {
		int[] C = new int[A.length];

		int[] count = new int[2];
		for (int i = 0; i < A.length; i++) {
			count[A[i]]++;
		}

		for (int i = 0; i < count[1]; i++) {
			C[count[0] + i] = 1; // start after count of zero.
		}

		PrintUtil.printArray(C);
	}

	/* Function to put all 0s on left and all 1s on right */
	private static void segregate0and1(int arr[]) {
		int size = arr.length;
		/* Initialize left and right indexes */
		int left = 0, right = size - 1;

		while (left < right) {
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				right--;

			/*
			 * If left is smaller than right then there is a 1 at left and a 0 at right.
			 * Exchange arr[left] and arr[right]
			 */
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
		PrintUtil.printArray(arr);
	}
}
