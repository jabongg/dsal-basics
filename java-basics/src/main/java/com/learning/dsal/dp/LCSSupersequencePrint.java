package com.learning.dsal.dp;

public class LCSSupersequencePrint {

	private static String printSubsequence(int[][] t, char[] X, char[] Y) {
		int i = t.length - 1;
		int j = t[0].length - 1;

		char[] ch = new char[X.length + Y.length]; int k = 0;
		
		while (i > 0 & j > 0) {
			if (X[i - 1] == Y[j - 1]) {
				char currentCharacter = X[i - 1];
				ch[k++] = currentCharacter;				
				//System.out.println(X[i - 1]); // we can put in a stack and then print for correct order
				i--;
				j--;
			} else if (t[i][j - 1] > t[i - 1][j]) {
				ch[k++] = Y[j - 1];
				j--;
			} else {
				ch[k++] = X[i - 1];
				i--;
			}
		}
		
		// for remaining characters: for string with greater length
		while (i > 0) {
			ch[k++] = X[i - 1];
			i--;
		}
		
		while (j > 0) {
			ch[k++] = Y[j - 1];
			j--;
		}
		return new String(ch);
	}
	

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
 
		printLongestCommonSupersequence(X, Y, m, n);
		
		//System.out.println("Length of LCS super-sequence is" + " " + longestCommonSupersequence(X, Y, m, n));
	}

	// this method returns length of the longest common super-sequence
	private static void printLongestCommonSupersequence(char[] X, char[] Y, int m, int n) {
		int[][] t = longestCommonSubsequence(X, Y, m, n);
		String str = printSubsequence(t, X, Y);
		System.out.println(str);
	}

}
