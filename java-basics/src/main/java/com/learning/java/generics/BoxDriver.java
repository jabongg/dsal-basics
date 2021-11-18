package com.learning.java.generics;

import java.util.ArrayList;
import java.util.Collection;

public class BoxDriver {
	public static void main(String[] args) {
		//Box<String> stringBox = new Box<>();
		//Box rawBox = stringBox;
		//rawBox.set(8);

		// T[] t = new T[];
		// countGreaterThan(new int[] {1, 32, 23, 14 }, 25);
		
		Box[] stringBox = new Box[10];
		Collection<?> c = new ArrayList<String>();
		//c.add(new Object()); // Compile time error
	}

	public static <T extends Comparable> int countGreaterThan(T[] anArray, T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0) // compiler error
				++count;
		return count;
	}
	
	void printCollection(Collection<?> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
	
	
}
