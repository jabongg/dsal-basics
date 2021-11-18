package com.example.designpatterns;

public class SingletonPatternDemo {

	public static void main(String[] args) {
		// SingleObject s = new SingleObject(); // will not work as constructor is private
		
		// lets get the object 
		SingleObject object = SingleObject.getInstance();
		object.showMessage();
		
		
	}
}
