package com.learning.site.ctci;

/**
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java Given two
 * 
 * strings, write a method to decide if one is a permutation of the other
 * 
 * @author User
 *
 */
public class TwoPermutatedStrings {
	public static void main(String[] args) {
		String str1 = "taco cat";
		String str2 = "atco cta";

		checkIfTwoStringsArePermutations(str1, str2);

		String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}

	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	public static boolean permutation(String s, String t) {
		return sort(s).equals(sort(t));
	}

	// english alphabet
	private static boolean checkIfTwoStringsArePermutations(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < str1.length(); i++) {
			sum1 += str1.charAt(i);
		}

		for (int i = 0; i < str2.length(); i++) {
			sum2 += str2.charAt(i);
		}

		if (sum1 != sum2) {
			return false;
		}

		return true;
	}

}
