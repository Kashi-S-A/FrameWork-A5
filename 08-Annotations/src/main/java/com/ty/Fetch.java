package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em1 = emf.createEntityManager();

		User u1 = em1.find(User.class, 1);
		System.out.println(u1);

		User u2 = em1.find(User.class, 1);
		System.out.println(u2);

		User u3 = em1.find(User.class, 2);
		System.out.println(u3);

		User u4 = em1.find(User.class, 2);
		System.out.println(u4);

		System.out.println("==========================");

		EntityManager em2 = emf.createEntityManager();

		User us1 = em2.find(User.class, 1);
		System.out.println(us1);

		User us2 = em2.find(User.class, 1);
		System.out.println(us2);

		User us3 = em2.find(User.class, 2);
		System.out.println(us3);

		User us4 = em2.find(User.class, 2);
		System.out.println(us4);
	}
}
