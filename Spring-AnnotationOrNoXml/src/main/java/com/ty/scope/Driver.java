package com.ty.scope;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee emp1 = app.getBean(Employee.class);

		Employee emp2 = app.getBean(Employee.class);

		Employee emp3 = app.getBean(Employee.class);

		System.out.println(emp1);

		System.out.println(emp2);

		System.out.println(emp3);
	}
}
