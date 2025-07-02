package com.ty.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

//	@Autowired
	private Engine engine;

	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}

//	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void race() {
		if (engine != null) {
			engine.start();
			System.out.println("Car is racing!");
		} else {
			System.out.println("No engine available.");
		}
	}
}
