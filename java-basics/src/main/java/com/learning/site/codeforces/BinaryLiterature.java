package com.learning.site.codeforces;

import java.util.Scanner;

/**
 * A bitstring is a string that contains only the characters 0 and 1.

Koyomi Kanou is working hard towards her dream of becoming a writer. To practice, she decided to participate in the Binary Novel Writing Contest. The writing prompt for the contest consists of three bitstrings of length 2n. A valid novel for the contest is a bitstring of length at most 3n that contains at least two of the three given strings as subsequences.

Koyomi has just received the three prompt strings from the contest organizers. Help her write a valid novel for the contest.

A string a is a subsequence of a string b if a can be obtained from b by deletion of several (possibly, zero) characters.

Input
The first line contains a single integer t (1≤t≤104) — the number of test cases.

The first line of each test case contains a single integer n (1≤n≤105).

Each of the following three lines contains a bitstring of length 2n. It is guaranteed that these three strings are pairwise distinct.

It is guaranteed that the sum of n across all test cases does not exceed 105.

Output
For each test case, print a single line containing a bitstring of length at most 3n that has at least two of the given bitstrings as subsequences.

It can be proven that under the constraints of the problem, such a bitstring always exists.

If there are multiple possible answers, you may output any of them.

Example
inputCopy
2
1
00
11
01
3
011001
111010
010001
outputCopy
010
011001010
Note
In the first test case, the bitstrings 00 and 01 are subsequences of the output string: 010 and 010. Note that 11 is not a subsequence of the output string, but this is not required.

In the second test case all three input strings are subsequences of the output string: 011001010, 011001010 and 011001010.
 * @author User
 *
 *
 *
 */
public class BinaryLiterature {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while (T-- > 0) {
			int N = scan.nextInt();
			String str1 = scan.next();
			String str2 = scan.next();
			String str3 = scan.next();
			
			printBinaryLiteratureString(N, str1, str2, str3);
		}
	}

	private static void printBinaryLiteratureString(int N, String s1, String s2, String s3) {

		// lcs pattern question ... supersequence of 3 strings

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
 
		printLongestCommonSupersequence(X, Y, m, n);
	}
	
	
	
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

	// this method returns length of the longest common super-sequence
	private static void printLongestCommonSupersequence(char[] X, char[] Y, int m, int n) {
		int[][] t = longestCommonSubsequence(X, Y, m, n);
		String str = printSubsequence(t, X, Y);
		System.out.println(str);
	}
}


