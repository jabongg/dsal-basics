package com.example.designpatterns;

public class SingleObject {

	// making constructor private so that this class cannot be instantiated from any outer class.
	private SingleObject() {}


	// create an object of SingleObject
	private static SingleObject instance = new SingleObject();
	
	public static SingleObject getInstance() {
		
		if (instance == null) { // lazy loading
			synchronized (SingleObject.class) {
				if (instance == null) {
					instance = new SingleObject();
				}
			}
		}
		return instance;
	}
	
	class BillPaugh {
		private final SingleObject INSTANCE = new SingleObject();
	}
	
	public void showMessage() {
		System.out.println("hello!");
	}
}
