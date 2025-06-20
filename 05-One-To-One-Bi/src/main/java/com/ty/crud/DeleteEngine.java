package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Engine;

public class DeleteEngine {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Engine engine = entityManager.find(Engine.class, 222);
		
		if (engine != null) {
			entityTransaction.begin();
			entityManager.remove(engine);
			entityTransaction.commit();
			System.out.println("Engine deleted successfully");
		} else {
			System.out.println("Engine not found");
		}

	}
}
