package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsEmployee {

	public static void main(String[] args) {
		Employee e1 = new Employee("Ajay", 23);
		Employee e2 = new Employee("babita", 78);
		Employee e3 = new Employee("Chintu", 18);
		Employee e4 = new Employee("Deepika", 67);
		Employee e5 = new Employee("Emily", 12);
		Employee e6 = new Employee("Fulgen", 29);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);
		
		// filter all the employees with age > 20 and print their names only.
		
		List<String> names = employees.stream()
		.filter(e -> e.getAge() > 20)
		.map(Employee::getName)
		.collect(Collectors.toList());
		
		names.forEach(System.out::println);
	}
}
