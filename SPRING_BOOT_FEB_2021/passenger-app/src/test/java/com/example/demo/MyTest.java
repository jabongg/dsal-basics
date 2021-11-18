package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTest {

	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("afterEach");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}	
	
	@Test
	public void test2() {
		System.out.println("test2");
	}	
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
