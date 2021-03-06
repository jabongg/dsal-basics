package com.learning.dsal.dp;

import java.util.HashMap;
import java.util.Map;

public class SequencePatternMatching {

	public static void main(String[] args) {
		String pattern = "AXAY";
		String sampleStr = "ADXCPAY";

		System.out.println(doesPatternExists(sampleStr, pattern));

		//boolean isPatternPresent = isPatternPresent(sampleStr, pattern);
		//System.out.println(isPatternPresent);
	}

	/**
	 * the approach I was trying but failed
	 * @param sampleStr
	 * @param pattern
	 * @return
	 */
	private static boolean isPatternPresent(String sampleStr, String pattern) {

		Map<Character, Integer> characterMap = new HashMap<>();
		for (int i = 0; i < sampleStr.length(); i++) {
			characterMap.put(sampleStr.charAt(i), i);
		}

		// key is present in map and index stored in the map for that character is less
		// than the index of
		// character in the map, then print false
		// else continue... in the end if everything is fine, return true;

		int lastIndex = -1;

		for (int i = 0; i < pattern.length(); i++) {

			if (null == characterMap.get(pattern.charAt(i))) {
				return false;
			}

			int currentIndex = characterMap.get(pattern.charAt(i));
			if (characterMap.containsKey(pattern.charAt(i))) {
				//
				if (currentIndex < lastIndex) {
					return false; // repeating ke case me problem hogi... how will you handle it?
				}
				lastIndex = currentIndex;

			}
		}
		return true;
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int longestCommonSubsequence(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	private static boolean doesPatternExists(String sampleStr, String pattern) {
		int lcs = longestCommonSubsequence(sampleStr.toCharArray(), pattern.toCharArray(), sampleStr.length(),
				pattern.length());
		if (lcs == pattern.length())
			return true;
		return false;
	}
}
