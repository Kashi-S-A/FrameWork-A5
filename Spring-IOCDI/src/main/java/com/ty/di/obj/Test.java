package com.ty.di.obj;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config3.xml");

		System.out.println("----------------Car------------------");
		Car car = (Car) app.getBean("myCar");
		System.out.println("Brand : " + car.getBrand());

		System.out.println("================Engine===============");
		Engine engine = car.getEngine();
		System.out.println("Fuel : " + engine.getType());
		System.out.println("cc : " + engine.getCc());

	}
}
