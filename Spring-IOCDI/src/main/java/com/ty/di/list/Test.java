package com.ty.di.list;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config4.xml");

		Student student = (Student) app.getBean("stu");

		student.displayStudentInfo();
	}
}
