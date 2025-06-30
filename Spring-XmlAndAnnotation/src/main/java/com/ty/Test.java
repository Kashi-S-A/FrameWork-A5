package com.ty;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Person person = (Person) app.getBean("person");

		person.run();

		MyApp a = (MyApp) app.getBean("myApp");

		a.login();

		RCB rcb = (RCB) app.getBean("myRCB");// default bean id will be RCB

		rcb.play();
	}
}
