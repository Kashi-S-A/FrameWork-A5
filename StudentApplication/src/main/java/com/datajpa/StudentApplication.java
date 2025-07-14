package com.datajpa;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.datajpa.service.StudentService;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(StudentApplication.class, args);

		StudentService service = run.getBean(StudentService.class);

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
			System.out.println("6. to fetch Sorted records");
			System.out.println("7. to end operations");
			System.out.println("8. for filtering");
			System.out.println("9. fetch by phone");
			System.out.println("10. fetch By name containing");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				service.saveStudent();
			}
				break;
			case 2: {
				service.updateStudent();
			}
				break;
			case 3: {
				service.deletStudent();
			}
				break;
			case 4: {
				service.pagination();
			}
				break;
			case 5: {
				service.fetchStudentById();
			}
				break;
			case 6: {
				service.sortStudents();
			}
				break;
			case 8: {
				service.filterStudents();

			}
				break;
			case 9: {
				System.out.println("enter phone No : ");
				long phone = sc.nextLong();
				service.getByPhone(phone);
			}
				break;
			case 10: {
				System.out.println("enter name: ");
				String name = sc.next();
				service.getByNameContaining(name);
			}
				break;
			case 7: {
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
