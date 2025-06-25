package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Person;
import com.ty.entity.PersonId;

public class SavePerson {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println(emf);
		System.out.println(em);
		System.out.println(et);

		Person person = new Person();
		person.setName("John Doe");
		person.setAge(30);
		
		PersonId personId = new PersonId();
		personId.setEmail("johnxyz@gmail.com");
		personId.setPhone(2234567890L);
		
		person.setPersonId(personId);

		et.begin();
		em.persist(person);
		et.commit();

		System.out.println("Person saved successfully!");

	}
}
