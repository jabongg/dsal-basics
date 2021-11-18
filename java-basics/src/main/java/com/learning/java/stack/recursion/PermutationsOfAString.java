package com.learning.java.stack.recursion;

public class PermutationsOfAString {
/**
 * To print the permutations of a given string.
 */
	
	public static void main(String[] args) {
		String str = "ABC";
		printPermutations(str, "");
	}

private static void printPermutations(String str, String ans) {

	if (str.length() == 0) {
		System.out.print(ans + " ");
		return;
	}
	
	for (int i = 0; i < str.length(); i++) {
		// ith character of string
		char ch = str.charAt(i);
		
		// rest of the string after excluding ith character
		String restofString = str.substring(0, i) + str.substring(i + 1);
		
		// recursive call
		printPermutations(restofString, ans + ch);
	}
}
}
