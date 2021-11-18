package com.spring.demo;

public class Employee {

	private String name;
	private Integer rollNum;
	private Double percentage;


	public Employee(String name, Integer rollNum, Double percentage) {
		super();
		this.name = name;
		this.rollNum = rollNum;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNum() {
		return rollNum;
	}

	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", rollNum=" + rollNum + ", percentage=" + percentage + "]";
	}

	
}
