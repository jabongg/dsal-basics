package com.learning.site.ctci;

/**
 * String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters. For example, the string aabcccccaaa
 * would become a2b1c5a3. If the "compressed" string would not become smaller
 * than the original string, your method should return the original string. You
 * can assume the string has only uppercase and lowercase letters (a - z).
 * 
 * @author User
 *
 */
public class CompressString {
	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(compressString(str));
		
		String str1 = "abcd";
		System.out.println(str);
		System.out.println(compressBad(str1));
	}

	
	private static String compressString(String str) {

		if (str.length() < 2) {
			return str;
		}
		
		char[] compressed = new char[2 * str.length()]; // in case all the characters are distinct
		int k = 0;
		int i = 0;
		while (i < str.length()) {
			compressed[k++] = str.charAt(i);
			int count = 0;
			int endCount = 0;
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
					if (j == str.length() - 1) {
						endCount = j;
					}
				} else {
					i = j;
					break;
				}
			}
			compressed[k++] = (char) (count + '0');
			if (endCount == str.length() - 1) {
				i = endCount + 1; // index + 1 for array size
			}
		}
		return String.valueOf(compressed);
	}
	
	
	public static String compressBad(String str) {
		String compressedString = "";
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
	return compressedString.length() < str.length() ? compressedString : str;
	}
	
}
