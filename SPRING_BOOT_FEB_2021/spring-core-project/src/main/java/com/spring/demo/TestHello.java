package com.spring.demo;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestHello {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		HelloWorld hello = (HelloWorld) context.getBean("helloworld");
		hello.sayHello();
		
		Person person = (Person) context.getBean("person");
		System.out.println(person.toString());
		
		User user = (User) context.getBean("user");
		System.out.println(user.toString());
		//System.out.println(user.getCar().toString());
		context.close();
	}
}
