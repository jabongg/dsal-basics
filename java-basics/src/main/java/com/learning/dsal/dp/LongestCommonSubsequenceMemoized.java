package com.learning.dsal.dp;

public class LongestCommonSubsequenceMemoized {

	static int[][] t = new int[20][20]; // taking string lenth as 19 + 1: random length.
	
	// Initializing with -1

	public static void main(String[] args) {
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}
		
		String x = "Ameena";
		String y = "Amenda";

		lcsequence(x, y);
	}

	private static void lcsequence(String x, String y) {
		int n = x.length();
		int m = y.length();
		char[] xArray = x.toCharArray();
		char[] yArray = y.toCharArray();
		int lcsLength = lcs(xArray, yArray, n, m);
		System.out.println(lcsLength);
	}

	private static int lcs(char[] x, char[] y, int n, int m) {

		// base condition
		if (n == 0 || m == 0) {
			return 0;
		}

		if (t[n][m] != -1) {
			return t[n][m];
		}
		
		// if last characters match
		if (x[n - 1] == y[m - 1]) {
			return t[n][m] =  1 + lcs(x, y, n - 1, m - 1);
		} else {
			return t[n][m] = Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
		}
	}
}
