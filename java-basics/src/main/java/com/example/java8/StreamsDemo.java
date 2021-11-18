package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
	public static void main(String[] args) {
		
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 3).limit(2);
		streamIterated.forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(3, 8, 2, 9, 7, 13, 5);
		// get list of unique squares

		FunctionalInterfaceDemo obj = new FunctionalInterfaceDemo();
		obj = null;
		obj.eval(numbers, n -> n > 7); // notice about NO NullPointerException

		FunctionalInterfaceDemo.eval(numbers, n -> n > 7);

		List<Integer> squaresMap = numbers.stream().map(x -> x * x).collect(Collectors.toList());
		squaresMap.forEach(System.out::print);

		List<String> strings = Arrays.asList("abc", "bbb", "bc", "efg", "abcd", "aba", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		filtered.forEach(s -> s.split("b"));

		for (String s : filtered) {
			System.out.println(s);
		}

		Random random = new Random();
		random.ints(5, 1000, 8000).forEach(System.out::println);
		
		Integer[] arr = {123, 324, 343, 533, 21234};
		Stream numbers1 = Stream.of(arr);
		//numbers1.filter(n -> (n % 2 == 0)).collect(Collectors.toList());
	}

}
