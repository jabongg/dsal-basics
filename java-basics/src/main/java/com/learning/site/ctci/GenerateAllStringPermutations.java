package com.learning.site.ctci;

public class GenerateAllStringPermutations {
	public static void main(String[] args) {
		String str = "ABC";
		// permutation(str);
		permu(0, str);
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	private static void permu(int fixed, String s) {
		char[] chr = s.toCharArray();
		if (fixed == s.length())
			System.out.println(s);
		for (int i = fixed; i < s.length(); i++) {
			char c = chr[i];
			chr[i] = chr[fixed];
			chr[fixed] = c;
			permu(fixed + 1, new String(chr));
		}
	}
}
