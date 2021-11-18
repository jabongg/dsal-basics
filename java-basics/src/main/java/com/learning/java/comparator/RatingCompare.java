package com.learning.java.comparator;

import java.util.Comparator;

//Class to compare Movies by ratings
public class RatingCompare implements Comparator<Movie> {
	
	public int compare(Movie m1, Movie m2) {
		if (m1.getRating() > m2.getRating())
			return 1;
		if (m1.getRating() < m2.getRating())
			return -1;
		else
			return 0;
	}
}