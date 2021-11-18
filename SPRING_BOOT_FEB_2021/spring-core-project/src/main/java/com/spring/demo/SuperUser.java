package com.spring.demo;

public class SuperUser {

	private String name;
	private String accessPriviledge;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getAccessPriviledge() {
		return accessPriviledge;
	}

	public void setAccessPriviledge(String accessPriviledge) {
		this.accessPriviledge = accessPriviledge;
	}

	@Override
	public String toString() {
		return "SuperUser [name=" + name + ", accessPriviledge=" + accessPriviledge + "]";
	}

	
}
