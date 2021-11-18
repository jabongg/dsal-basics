package com.spring.demo;

public class User extends SuperUser {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [car=" + car + ", getName()=" + getName() + ", getAccessPriviledge()=" + getAccessPriviledge()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}
