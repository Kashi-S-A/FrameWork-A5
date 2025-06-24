package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Car;

public class DeleteCar {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Car car = entityManager.find(Car.class, 2);
		
		if (car != null) {
			entityTransaction.begin();
			entityManager.remove(car);
			entityTransaction.commit();
			System.out.println("Car deleted successfully");
		} else {
			System.out.println(" not found");
		}

	}
}
