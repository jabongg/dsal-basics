package com.learning.java.comparator;

//A class 'Movie' that implements Comparable
public class Movie implements Comparable<Movie> {
	private double rating;
	private String name;
	private int year;

	// Constructor
	public Movie(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int compareTo(Movie o) {
		return this.year - o.year;
	}

}
