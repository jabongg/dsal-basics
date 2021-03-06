package com.learning.dsal.dp;

public class LCSPrint {

	/* Returns table of LCS for X[0..m-1], Y[0..n-1] */
	static int[][] longestCommonSubsequence(char[] X, char[] Y, int m, int n) {
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
		return L;
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		int[][] t = longestCommonSubsequence(X, Y, m, n);
		printSubsequence(t, X, Y);

	}

	private static void printSubsequence(int[][] t, char[] X, char[] Y) {

		int i = t.length - 1;
		int j = t[0].length - 1;

		while (i > 0 & j > 0) {
			if (X[i - 1] == Y[j - 1]) {
				System.out.println(X[i - 1]); // we can put in a stack and then print for correct order
				i--;
				j--;
			} else if (t[i][j - 1] > t[i - 1][j]) {
				j--;
			} else {
				i--;
			}
		}
	}
	
	// sochenge is par
	private static void printSubsequenceCorrectOrder(int[][] t, char[] X, char[] Y) {

		int i = 1;
		int j = 1;

		while (i < t.length & j < t[0].length) {
			if (X[i + 1] == Y[j + 1]) {
				System.out.println(X[i + 1]); // we can put in a stack and then print for correct order
				i++;
				j++;
			} else if (t[i][j + 1] > t[i + 1][j]) {
				j++;
			} else {
				i++;
			}
		}
	}

}
