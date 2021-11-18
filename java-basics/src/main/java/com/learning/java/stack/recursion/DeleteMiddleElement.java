package com.learning.java.stack.recursion;

import java.util.Stack;

/*
 * TODO: delete the middle element of a stack
 * consider middle element as (stack.size() / 2 ) + 1 in 
 * both even and odd case of stack having size.
 * 
 */
public class DeleteMiddleElement {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(9);
		stack.push(-1);
		stack.push(120);
		stack.push(2);
		stack.push(92);

		System.out.println(stack);
		System.out.println();
		deleteMiddileElement(stack);
		System.out.println(stack);

	}

	private static void deleteMiddileElement(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		int middleElementIndex = (stack.size() / 2) + 1;
		solve(stack, middleElementIndex);

	}

	private static void solve(Stack<Integer> stack, int middleElementIndex) {

		if (middleElementIndex == 1) { // think of smallest valid middleElementIndex as base condition
			stack.pop();
			return;
		}
		int temp = stack.pop();
		solve(stack, middleElementIndex - 1); // passing the index - 1;
		stack.push(temp); // append the top element
		return;
	}
}
