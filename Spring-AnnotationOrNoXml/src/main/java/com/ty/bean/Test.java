package com.ty.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = app.getBean(Student.class);

		student.display();

		System.out.println("======================");

		Address a = (Address) app.getBean("myAddress");

		a.display();
	}
}
