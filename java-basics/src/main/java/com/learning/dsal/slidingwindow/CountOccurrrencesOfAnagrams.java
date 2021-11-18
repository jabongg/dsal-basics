package com.learning.dsal.slidingwindow;

/**
 * Given a word and a text, return the count of the occurrences of 
 * anagrams of the word in the text 
 * (For eg: anagrams of word 'for' are 'for', 'ofr', 'rof' etc.)
 * 
 * Input : forxxorfxdofr
 * pattern: for
 * output : 3
 * Explanation : Anagrams of the word for -> for orf, ofr 
 * appear in the text and hence the count is 3.
 * 
 * 
 * @author User
 *
 */
public class CountOccurrrencesOfAnagrams {

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String pattern = "for";
		System.out.println(countOccurencesOfAnagrams(text, pattern));
	}

	private static char[] countOccurencesOfAnagrams(String text, String pattern) {

		int N = text.length();
		int n = pattern.length();
		
		// initialize result
		int result = 0;
		for (int i = 0; i < N - n; i++) { // 13 - 3 = 10: times
			String s = text.substring(i, i + n);
			
		}
		
		return null;
	}
}
