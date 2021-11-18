package com.learning.java.comparator;

public class YearComparable implements Comparable<Movie> {

	@Override
	public int compareTo(Movie o) {
		return o.getYear();
	}

}
