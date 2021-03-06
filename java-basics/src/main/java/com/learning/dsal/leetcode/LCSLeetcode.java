package com.learning.dsal.leetcode;

public class LCSLeetcode {
    
	public static void main(String[] args) {
		String x = "abscde";
		String y = "asdcfe";
		System.out.println(longestCommonSubsequence(x, y));		
	}
	
    public static int longestCommonSubsequence(String x, String y) {
   
        int[][] t = new int[1001][1001]; // as per constraint.

        for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;
			}
		}
        
        int n = x.length();
		int m = y.length();
		char[] xArray = x.toCharArray();
		char[] yArray = y.toCharArray();
		return  lcs(xArray, yArray, n, m, t);
    }


	private static int lcs(char[] x, char[] y, int n, int m, int[][] t) {

		// base condition
		if (n == 0 || m == 0) {
			return 0;
		}

		if (t[n][m] != -1) {
			return t[n][m];
		}
		
		// if last characters match
		if (x[n - 1] == y[m - 1]) {
			return t[n][m] =  1 + lcs(x, y, n - 1, m - 1, t);
		} else {
			return t[n][m] = Math.max(lcs(x, y, n - 1, m, t), lcs(x, y, n, m - 1, t));
		}
	}
}
