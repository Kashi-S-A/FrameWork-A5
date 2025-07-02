package com.ty.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Constructor injection using @Value annotation
@Component
public class Car {

	String brand;
	double price;

	public void display() {
		System.out.println("Brand: " + brand + ", Price: " + price);
	}

	public Car(@Value(value = "Toyota") String brand, @Value(value = "500000d") double price) {
		this.brand = brand;
		this.price = price;
	}
}