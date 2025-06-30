package com.ty.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("configC.xml");

		School school = (School) app.getBean("mySchool");

		System.out.println("Name : "+school.getName());
		System.out.println("Address : "+school.getAddress());

	}
}
