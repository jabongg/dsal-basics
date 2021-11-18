package com.learning.dsal.dp;

public class MinimumDeletionsForPalindrome {

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

	public static void main(String[] args) {
		String s1 = "agbcba";

		// since we are not given the other string, we will make our own string by using
		// the property of a palindrome
		// that String.reverse is equal to the given string.
		StringBuffer sbr = new StringBuffer(s1);
		String s2 = new String(sbr.reverse());

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Minimum deletions to make string a palindrome is : " + " " + minimumDeletionsToMakePalindrome(X, Y, m, n));
	}

	// this method returns length of the longest common super-sequence
	private static int minimumDeletionsToMakePalindrome(char[] X, char[] Y, int m, int n) {
		return m - longestCommonSubsequence(X, Y, m, n);
	}

}
