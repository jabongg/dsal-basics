package com.learning.java.stack.recursion;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(-1);
		stack.push(120);
		stack.push(2);
		stack.push(92);

		System.out.println(stack);
		System.out.println();
		reverse(stack);
		System.out.println(stack);

	}

	private static void reverse(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}
		
		int temp = stack.pop();
		reverse(stack);
		insert(stack, temp);
		return;
	}

	private static void insert(Stack<Integer> stack, int element) {
		if (stack.size() == 0) {
			stack.push(element);
			return;
		}
		int temp = stack.pop();
		insert(stack, element);
		stack.push(temp);
		return;
	}
}
