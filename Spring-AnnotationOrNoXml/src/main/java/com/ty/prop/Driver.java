package com.ty.prop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

//		ReadConfig bean = app.getBean(ReadConfig.class);
//
//		System.out.println(bean.getUrl());
//		System.out.println(bean.getUser());
//		System.out.println(bean.getPwd());
//		System.out.println(bean.getSecrete());

		Person person = app.getBean(Person.class);

		person.read();
	}
}
