package com.learning.java.stack.recursion;

import java.util.Stack;

/*
 * sort stack using recursion
 */
public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(-1);
		stack.push(120);
		stack.push(2);
		System.out.println(stack);
		System.out.println();
		sort(stack);
		System.out.println(stack);
		
	}

	private static void sort(Stack<Integer> stack) {

		// base condition for sort.
		if (stack.isEmpty()) {
			return;
		}
		
		int temp = stack.pop();
		sort(stack);
		
		insertAtCorrectPosition(stack, temp);
	}

	// consult sanjeev regarding this visualization
	private static void insertAtCorrectPosition(Stack<Integer> stack, int temp) {
		if (stack.isEmpty() || stack.peek() < temp) {
			stack.push(temp);
			return;
		}
		
		int element = stack.pop();
		insertAtCorrectPosition(stack, temp);
		stack.push(element);
	}
}
