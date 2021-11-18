package com.learning.java.comparator;

import java.util.Comparator;

public class YearCompare implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
//		if (o1.getYear() > o2.getYear())
//			return 1;
//		if (o1.getYear() < o2.getYear()) 
//			return -1;
//		else 
//			return 0;
//		
		return o1.getYear() - o2.getYear();
	}

}
