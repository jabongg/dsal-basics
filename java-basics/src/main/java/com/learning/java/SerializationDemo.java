package com.learning.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {

	public static void main(String[] args) {

		Student s = new Student(222, "Ajay");

		// creating stream and writing the object to a file
		try {
			FileOutputStream fout = new FileOutputStream("f.txt");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s);
			oout.flush();

			oout.close();

			System.out.println("success");
			FileInputStream fis = new FileInputStream("f.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student deserialized_s = (Student) ois.readObject();
			System.out.println(deserialized_s.name + " " + deserialized_s.rollNum);

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Address {
	String city;

	public Address(String city) {
		super();
		this.city = city;
	}

}

class Student implements Serializable {
	int rollNum;
	String name;
	Address address; // HAS-A relationship
	
	public Student(int rollNum, String name) {
		super();
		this.rollNum = rollNum;
		this.name = name;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}