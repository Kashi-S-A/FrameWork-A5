package com.ty.di;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = 
	new ClassPathXmlApplicationContext("config.xml");

		Student student = (Student) app.getBean("student");

		student.display();

		System.out.println("==========================");

		Car car = (Car) app.getBean("car");

		car.display();

		System.out.println("==========================");

		Teacher teacher = (Teacher) app.getBean("teacher");

		teacher.display();

		System.out.println("==========================");
	}
}
