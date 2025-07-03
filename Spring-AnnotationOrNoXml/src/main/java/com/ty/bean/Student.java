package com.ty.bean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value(value = "Dinga")
	private String name;

	@Autowired
	private Address address;

	@Autowired
	private Map<Integer, String> map;

	@Autowired
	private List<String> subjects;

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Subjects: " + subjects);
		System.out.println("===========Address==========");
		address.display();
		System.out.println("============Details=============");

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}

	}
}
