package com.ty;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Person person = (Person) app.getBean("myPerson1");
		person.speak();

		Student student = (Student) app.getBean("myStudent1");
		student.study();

		app.close(); // Close the application context to release resources
	}
}
