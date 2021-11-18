package com.learning.java.collections;

public class Key {

	String key;

	public Key(String key) {
		this.key = key;
	}
	
//	@Override
//	public int hashCode() {
//		return (int) key.charAt(0);
//	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println(key + " " + o); 
		return key.equals(o);
	}
}
