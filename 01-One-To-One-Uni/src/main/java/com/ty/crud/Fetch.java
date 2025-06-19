package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Car;
import com.ty.entity.Engine;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Car car = em.find(Car.class, 1);

		if (car != null) {
			System.out.println(car);

			System.out.println("======================");

			Engine engine = car.getEngine();

			System.out.println(engine);

		} else {
			System.out.println("Not found");
		}
	}
}
