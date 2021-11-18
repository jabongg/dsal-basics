package com.spring.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class EmployeeDemo {

	/*
	 * Task is to :
	 * 1 ) find all students with nth (2nd) highest percentage.
	 * 2 ) sort students on basis of their percentage (highest first) and then on basis of name
	 */
	
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Ajay", 7, 90.00);
		Employee e2 = new Employee("Babita", 8, 90.00);
		Employee e3 = new Employee("Chandu", 10, 90.00);
		Employee e4 = new Employee("Dheeraj", 9, 90.00);
		Employee e5 = new Employee("Ekta", 1, 90.00);
		Employee e6 = new Employee("Anjum", 2, 99.00);
		Employee e7 = new Employee("Manisha", 3, 99.00);
		Employee e8 = new Employee("Yug", 11, 99.00);
		Employee e9 = new Employee("Nishant", 4, 89.08);
		Employee e10 = new Employee("Vikky", 5, 74.08);
		Employee e11 = new Employee("Praveen", 6, 65.06);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);
		employees.add(e7);
		employees.add(e8);
		employees.add(e9);
		employees.add(e10);
		employees.add(e11);
		
		System.out.println(employees);

		
		// case 1. find all students with 2nd highest percentage.
		employees.sort(Comparator.comparing(Employee::getPercentage).reversed().thenComparing(Employee::getName));
		Map<Double, List<Employee>> emap = new HashMap<>();
		
		System.out.println(employees.size());

		// logic for putting employees with percentage
		for (int i = 0; i < employees.size(); i++) {
			if (!Objects.isNull(emap)) {
				if (emap.containsKey(employees.get(i).getPercentage())) {
					List<Employee> lList = emap.get(employees.get(i).getPercentage());
					lList.add(employees.get(i));
					emap.put(employees.get(i).getPercentage(), lList);
				} else {
					List<Employee> lList = new LinkedList<Employee>();
					lList.add(employees.get(i));
					emap.put(employees.get(i).getPercentage(), lList);
				}
			}
		}
		
		//Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(Employee::getRollNum, Function.identity()));
		//emap.remove();
		
		//System.out.println(map);
		
		System.out.println(employees);
		System.out.println(emap);
		
//		PriorityQueue<Map.Entry<Double, List<Employee>>> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//		
//
//		for (Map.Entry<Double, List<Employee>> e : emap.entrySet()) {
//			maxHeap.add(e);
//		}
//		
//		System.out.println(maxHeap);
//		maxHeap.poll();
//		
//		System.out.println(maxHeap);
	}
}
