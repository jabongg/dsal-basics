package com.learning.java.array;

import java.util.Stack;

public class ReverseASentence {
	public static void main(String[] args) {

		String str = "Geeksforgeeks for geeks";
		String[] words = str.split(" ");

		Stack<String> s = new Stack<>();
		for (String word : words) {
			s.push(word);
		}


		while (!s.isEmpty())
			System.out.println(s.pop());

	}
}
