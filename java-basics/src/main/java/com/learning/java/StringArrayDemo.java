package com.learning.java;

public class StringArrayDemo {

	public static void main(String[] args) {
		String[] strArray = { "1, 3, 4, 7, 13", "1, 2, 4, 13, 15" };

		String palindrome = "never odd or even";
		
		String s2 = palindrome.replace(" ", "");
		System.out.println(s2);

		String A = strArray[0];
		String B = strArray[1];

		System.out.println(A + " " + B);

		String[] arr1 = A.split(",");
		String[] arr2 = B.split(",");

		String[] output = new String[arr1.length + arr2.length];

		int k = 0;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (Integer.parseInt(arr2[j].trim()) > Integer.parseInt(arr1[i].trim())) {
					break;
				}
				if (arr1[i].equals(arr2[j])) {
					output[k++] = arr1[i].trim();
					break;
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		
		for (String str : output) {
			if (str == null) break;
				sb.append(str + ",");
				
			System.out.println(str);
		}
		
		sb.deleteCharAt(sb.length() - 1);
		
		String out = new String(sb);
		System.out.println(out);
		//return out;
		
		//System.out.println(out);
	}

}
