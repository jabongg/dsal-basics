package com.learning.java.stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] A = { 1, 3, 2, 4 };
		System.out.println("element :" + A[A.length - 1] + " next higher : " + findNextGreaterElement(A));
		System.out.println(findNextGreaterElementUsingStack(A));
	}

	private static int findNextGreaterElement(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] > A[i]) {
					System.out.println("element :" + A[i] + " next higher : " + A[j]);
					break;
				}
				if (j == A.length - 1) {
					System.out.println("element :" + A[i] + " next higher : " + "-1");
				}
			}
		}

		return -1; // for last element, which does not have any greater value : corner case
	}

	private static Stack<Integer> findNextGreaterElementUsingStack(int[] A) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> solution = new Stack<>();

		for (int i = A.length - 1; i >= 0; i--) {

			if (stack.size() == 0) {
				solution.add(-1);
			} else if (stack.size() > 0 && stack.peek() > A[i]) {
				solution.add(stack.peek());
			} else if (stack.size() > 0 && stack.peek() <= A[i]) {
				while (stack.size() > 0 && stack.peek() <= A[i]) {
					stack.pop();
				}

				if (stack.size() == 0) {
					solution.add(-1);
				} else {
					solution.add(stack.peek());
				}
			}

			stack.add(A[i]);

		}
		return solution;
	}
}
