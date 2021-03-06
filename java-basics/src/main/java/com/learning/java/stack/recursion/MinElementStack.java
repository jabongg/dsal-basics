package com.learning.java.stack.recursion;

import java.util.Stack;

/**
 * find minimum element in a stack using O(1) space
 * @author User
 *
 */
public class MinElementStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(93);
		stack.push(57);
		stack.push(47);
		stack.push(34);
		stack.push(16);
		stack.push(72);
		stack.push(94);
		
		
		System.out.println(stack.size());
		int minimumElement = minimumElementInStack(stack);
		System.out.println(minimumElement);
	}

	// solution using O(1) space
	public static int minimumElementInStack(Stack<Integer> stack) {
		int minimumElement = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			if (stack.peek() < minimumElement) {
				minimumElement = stack.peek();
			}
			stack.pop();
		}
		return minimumElement;
	}
	

}
