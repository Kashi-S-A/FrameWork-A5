package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Student;
import com.ty.entity.Subject;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, 2);

		if (student != null) {
			System.out.println("===========Student found:============");
			System.out.println("ID: " + student.getId());
			System.out.println("Name: " + student.getName());
			System.out.println("Standard: " + student.getStd());

			System.out.println("=============Subjects:============ ");
			List<Subject> subjects = student.getSubjects();

			for (Subject subject : subjects) {
				System.out.println("Subject ID: " + subject.getId());
				System.out.println("Subject Name: " + subject.getName());
				System.out.println("Days: " + subject.getDays());
				System.out.println("-------------------------------");
			}

		} else {
			System.out.println("Student not found");
		}
	}
}
