package com.example.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToIntDemo {

	// Driver code
	public static void main(String[] args) {

//		// Creating a list of Strings
//		List<String> list = Arrays.asList("3", "6", "8", "14", "15");
//
//		list
//		.stream()
//		.mapToInt(num -> Integer.parseInt(num))
//		.filter(num -> num % 3 == 0) 
//		.forEach(System.out::println);
//		
//		
		  String[] s = {"one", "two", "three", "four"};
	        Stream<String> stringStream = Stream.of(s);
	        IntStream intStream = stringStream.mapToInt(e -> e.length());
	        IntSummaryStatistics stats = intStream.peek(System.out::println)
	                                              .summaryStatistics();
	        System.out.println(stats.getAverage());
	        
	        
	        int sum = IntStream.of(1, 2, 3, 4)
	         .filter(e -> e > 1)
	         .peek(e -> System.out.println("Filtered value: " + e))
	         .map(e -> e * e)
	         .peek(e -> System.out.println("Mapped value: " + e))
	         .sum();
	        System.out.println(sum);

		// Using Stream mapToInt(ToIntFunction mapper)
		// and displaying the corresponding IntStream
		//list.stream().mapToInt(num -> Integer.parseInt(num)).filter(num -> num % 3 == 0).forEach(System.out::println);
	}
}
