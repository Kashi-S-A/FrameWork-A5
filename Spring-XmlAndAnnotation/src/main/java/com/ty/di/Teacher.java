package com.ty.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Field or Variable injection using @Value annotation
@Component
public class Teacher {

	@Value(value = "John Doe")
	private String name;

	@Value(value = "35")
	private int age;

	public void display() {
		System.out.println("Name: " + name + ", Age: " + age);
	}

}
