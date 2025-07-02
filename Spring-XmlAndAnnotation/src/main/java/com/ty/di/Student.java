package com.ty.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Setter injection using @Value annotation
@Component
public class Student {

	private String name;
	private int age;

	public void display() {
		System.out.println("Name: " + name + ", Age: " + age);
	}

	@Value(value = "Dinga")
	public void setName(String name) {
		this.name = name;
	}

	@Value(value = "20")
	public void setAge(int age) {
		this.age = age;
	}

}
