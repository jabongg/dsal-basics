package com.learning.dsal.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
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

		// if last characters match
		if (x[n - 1] == y[m - 1]) {
			return 1 + lcs(x, y, n - 1, m - 1);
		} else {
			return Math.max(lcs(x, y, n - 1, m), lcs(x, y, n, m - 1));
		}
	}
}
