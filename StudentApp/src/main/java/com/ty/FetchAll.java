package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

//		String hql = "select s from Student s";

		String hql = "select s from Student s where s.sid=:studId";

		String hql1 = "select s from Student s where s.sid=?1";

		Query query = em.createQuery(hql1);
//		query.setParameter("studId", 101);
		query.setParameter(1, 104);

		List<Student> students = query.getResultList();
		System.out.println("+======students=========");
		for (Student student : students) {
			System.out.println(student);
			System.out.println("--------------");
		}
	}
}
