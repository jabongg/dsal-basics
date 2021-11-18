package com.learning.site.geekforgeeks;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		//String str2 = "andmananamandnikobaram";
		//System.out.println(nonrepeatingCharacter(str2));

		String str = "#Acd#ijk%dcjk$";
		char[] output = new char[str.length()];
		char[] input = str.toCharArray();

		for (int i = 0; i < input.length; i++) {
			if ((input[i] >= 'a' && input[i] <= 'z') || (input[i] >= 'A' && input[i] <= 'Z')) {
				output[i] = input[i];
			} else {
				output[i] = ' '; // space character
			}
		}

		// print(input);
		// System.out.println();
		// print(output);

		char[] ch = new char[output.length];
		int k = 0;
		for (int i = 0; i < output.length; i++) {
			if (output[i] == ' ') {
				continue;
			}
			ch[k++] = output[i];
		}

		print(ch);

		// out input : acdijkdcjk

		firstNonRepeatingChar(ch);

		/*
		 * int breakPoint = 3; // can vary int count = 0; for (int i = 0; i < ch.length;
		 * i++) { count++; System.out.print(ch[i]); if (count % breakPoint == 0) { count
		 * = 0; System.out.println(); } }
		 */

		// System.out.print(String.valueOf(output));
	}

	static char nonrepeatingCharacter(String str) {
		int[] alpha = new int[26];

		for (char c : str.toCharArray()) {
			alpha[c - 'a']++;
		}

		for (int i = 0; i < str.length(); ++i) {
			if (alpha[str.charAt(i) - 'a'] == 1) {
				return str.charAt(i);
			}
		}
		return '$';
	}

	public static void firstNonRepeatingChar(char[] chh) {
		int[] count = new int[26];
		for (int i = 0; i < chh.length; ++i) {
			
			if (chh[i] != '\0') {
				
				if (chh[i] >= 'A' && chh[i] <= 'Z') {
					chh[i] = (char) (chh[i] + 32);
				}
				
				count[chh[i] - 'a']++;
			}
			/*
			 * // toUpperCase toLowerCase... if (input[i] >= 'A' && input[i] <= 'Z') {
			 * count[input[i]]++; } else { count[input[i]]++; }
			 */
		} // end

		for (int i = 0; i < chh.length; i++) {
			
			if (chh[i] != '\0' && count[chh[i] - 'a'] == 1) {
				System.out.println("\n"+ chh[i]); // printing the firstNonRepeatingChar
				break;
			}
		}

	}

	public static void print(char[] output) {
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
		}
	}

}
