package com.learning.java;

import java.util.Scanner;

/**
 * String Challenge Have the function StringChallenge(str) read str which will
 * contain two strings separated by a space. The first string will consist of
 * the following sets of characters: +, *, and {N} which is optional. The plus
 * (+) character represents a single alphabetic character, the asterisk (*)
 * represents a sequence of the same character of length 3 unless it is followed
 * by {N} which represents how many characters should appear in the sequence
 * where N will be at least 1. Your goal is to determine if the second string
 * exactly matches the pattern of the first string in the input.
 * 
 * For example: if str is "++*{5} gheeeee" then the second string in this case
 * does match the pattern, so your program should return the string true. If the
 * second string does not match the pattern your program should return the
 * string false. Examples
 * 
 * Input: "+++++* abcdemmmmmm" Output: false Input: "**+*{2} mmmrrrkbb" Output:
 * true
 * 
 * @author User
 *
 */
public class WildCardMatching {

	public static String StringChallenge(String str) {

		// split the inputs
		String[] input = str.split(" ");
		String pattern = input[0];
		String matching = input[1];

		boolean matches = patternMatching(pattern, matching);
		if (matches)
			return "true";
		else
			return "false";
	}

	private static boolean patternMatching(String pattern, String matching) {
		// trim the unnecessary characters
		pattern = pattern.substring(1);
		matching = matching.substring(0, matching.length() - 1);

		System.out.println(pattern);
		System.out.println(matching);

		char[] patternArray = pattern.toCharArray();
		char[] matchingArray = matching.toCharArray();

		int lastIndexMatching = 0; // it will store the last position of matching string
		int currIndexPattern = 0; // it will store the current position of the pattern string.

		for (int i = 0; i < pattern.length(); i++) {

			if (pattern.charAt(i) == '+') {
				// look into the matcher sample string
				if (matching.charAt(lastIndexMatching) == '\0' || matching.charAt(lastIndexMatching) == ' ') {
					return false;
				}
				lastIndexMatching++;
			}

			if (pattern.charAt(i) == '*') {

				if (i != pattern.length() - 1) {
					if (pattern.charAt(i + 1) == '{') { // check if next char to * is {
						// check for 3 consecutive characters: if not return false;
						
						// go to next index to get the value for how many times the character to be
						// repeated.
						int value = Character.getNumericValue(pattern.charAt(i + 2));
						
						
						for (int el = 0; el < value; el++) {
							if (lastIndexMatching != matching.length() - 1) {
								if (!(matching.charAt(lastIndexMatching) == matching.charAt(lastIndexMatching + 1))) {
									return false;
								}
							}
							lastIndexMatching++;
						}
						lastIndexMatching++;
					}
					
					if (pattern.charAt(i + 1) != '{') { // check if next char to * is {
						// check for 3 consecutive characters: if not return false;
						for (int el = 0; el < 3 - 1; el++) {
							if (lastIndexMatching != matching.length() - 2) {
								if (!(matching.charAt(lastIndexMatching) == matching.charAt(lastIndexMatching + 1))) {
									return false;
								}
							}
							lastIndexMatching++;
						}
						lastIndexMatching++;
					}
				}

			}

			// check if there are extra characters though passes the pattern
			if ((i == pattern.length() - 1) && (lastIndexMatching - 1 != matching.length())) { // since lastIndexMatching++ increases the value by 1
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge(s.nextLine())); // input : "+++++* abcdemmmmmm"
		s.close();
	}

}
