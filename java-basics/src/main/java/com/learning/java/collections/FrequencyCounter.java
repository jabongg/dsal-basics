package com.learning.java.collections;

import java.util.*;

public class FrequencyCounter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		Map<Character, Integer > map = frequencyCounter(str);
		for ( Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
	
	public static Map<Character, Integer > frequencyCounter(String str) {
		Map<Character, Integer > map = new TreeMap<>(); // for sorted order of keys
		
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}

		return map;
	}
}