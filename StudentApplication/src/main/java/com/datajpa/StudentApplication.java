package com.datajpa;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(StudentApplication.class, args);

		StudentRepository repo = run.getBean(StudentRepository.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("==========================");
			System.out.println("| Welcome to Student app |");
			System.out.println("==========================");
			System.out.println("1. to save");
			System.out.println("2. to update");
			System.out.println("3. to delete");
			System.out.println("4. to fetchall");
			System.out.println("5. to fetch By Id");
			System.out.println("6. to end operations");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				Student s = new Student();
				System.out.println("enter student name : ");
				s.setName(sc.next());
				System.out.println("enter student phone : ");
				s.setPhone(sc.nextLong());

				Student saved = repo.save(s);
				System.out.println("-----------------------------------------------------");
				System.out.println("student save successfully with Id : " + saved.getSid());
				System.out.println("-----------------------------------------------------");
			}
				break;
			case 2: {
				System.out.println("------------------------------");
				System.out.println("enter id of Student to update");
				System.out.println("------------------------------");
				Long sid = sc.nextLong();
				Optional<Student> opt = repo.findById(sid);
				if (opt.isPresent()) {
					Student student = opt.get();
					System.out.println("enter new Name : ");
					student.setName(sc.next());
					Student saved = repo.save(student);
					System.out.println("-----------------------------------------------");
					System.out.println("Student name is update to : " + saved.getName());
					System.out.println("-----------------------------------------------");
				} else {
					System.out.println("----------------------------");
					System.out.println("Student not found to update");
					System.out.println("-----------------------------");
				}

			}
				break;
			case 3: {
				System.out.println("------------------------------");
				System.out.println("enter id of Student to Delete");
				System.out.println("------------------------------");
				Long sid = sc.nextLong();
				repo.deleteById(sid);
				System.out.println("-----------------");
				System.out.println("Student Deleted");
				System.out.println("------------------");
			}
				break;
			case 4: {
				Iterable<Student> students = repo.findAll();
				if (students != null) {
					System.out.println("============Students============");
					for (Student student : students) {
						System.out.println("sid   : " + student.getSid());
						System.out.println("name  : " + student.getName());
						System.out.println("phone : " + student.getPhone());
						System.out.println("=============================");
					}
				} else {
					System.out.println("------------------");
					System.out.println("No students found");
					System.out.println("------------------");
				}
			}
				break;
			case 5: {
				System.out.println("------------------------------");
				System.out.println("enter id of Student to Fetch :");
				System.out.println("------------------------------");
				Long sid = sc.nextLong();
				Optional<Student> opt = repo.findById(sid);
				if (opt.isPresent()) {
					Student student = opt.get();
					System.out.println("=========Student==========");
					System.out.println("sid   : " + student.getSid());
					System.out.println("name  : " + student.getName());
					System.out.println("phone : " + student.getPhone());
				} else {
					System.out.println("Student not found");
					// throw new RuntimeException();
				}
				System.out.println("------------------------------");

//				Student student = opt.orElseThrow(() -> new RuntimeException("Student Not found"));
//				System.out.println("=========Student==========");
//				System.out.println("sid   : "+student.getSid());
//				System.out.println("name  : "+student.getName());
//				System.out.println("phone : "+student.getPhone());
			}
				break;
			case 6: {
				System.out.println("---------------------");
				System.out.println("Thank You!!!!!!!!!!!");
				System.out.println("---------------------");
				return;
			}
			default: {
				System.out.println("--------------");
				System.out.println("invalid input");
				System.out.println("--------------");
			}
				break;
			}

		}
	}

}
