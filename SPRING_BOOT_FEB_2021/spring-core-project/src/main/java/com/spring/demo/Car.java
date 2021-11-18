package com.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class Car {

	private String name;
	private String perDayCost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPerDayCost() {
		return perDayCost;
	}

	public void setPerDayCost(String perDayCost) {
		this.perDayCost = perDayCost;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", perDayCost=" + perDayCost + "]";
	}

}
