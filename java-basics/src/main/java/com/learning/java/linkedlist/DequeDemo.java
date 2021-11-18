package com.learning.java.linkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DequeDemo {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(2);
		dq.add(1);

	}

	public boolean isPalindrome(Deque<Integer> dq) {
		while (dq.size() > 0) {
			if (dq.peekFirst() != dq.peekLast()) {
				System.out.println("not palindrome");
				return false;
			}
			dq.pollFirst();
			dq.pollLast();
		}
		return true;
	}
}
