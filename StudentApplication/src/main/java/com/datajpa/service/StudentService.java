package com.datajpa.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.datajpa.entity.Student;
import com.datajpa.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private Scanner sc;

	public void saveStudent() {
		Student s = new Student();
		System.out.println("enter student name : ");
		String name = sc.next();
		s.setName(name);
		System.out.println("enter student phone : ");
		s.setPhone(sc.nextLong());

		Student saved = repo.save(s);
		System.out.println("-----------------------------------------------------");
		System.out.println("student save successfully with Id : " + saved.getSid());
		System.out.println("-----------------------------------------------------");
	}

	public void updateStudent() {
		System.out.println("------------------------------");
		System.out.println("enter id of Student to update");
		System.out.println("------------------------------");
		Long sid = sc.nextLong();
		Optional<Student> opt = repo.findById(sid);
		if (opt.isPresent()) {
			Student student = opt.get();
			System.out.println("enter new Name : ");
			String newName = sc.next();
			student.setName(newName);
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

	public void deletStudent() {
		System.out.println("------------------------------");
		System.out.println("enter id of Student to Delete");
		System.out.println("------------------------------");
		Long sid = sc.nextLong();
		repo.deleteById(sid);
		System.out.println("-----------------");
		System.out.println("Student Deleted");
		System.out.println("------------------");
	}

	public void pagination() {
		System.out.println("Enter the pageNumber, starts from 1");

		int pageNumber = sc.nextInt();

		System.out.println("Enter the number of records");

		int pageSize = sc.nextInt();

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);// start pageNumber will be 0.

		Page<Student> all = repo.findAll(pageable);

		List<Student> students = all.toList();

		printStudents(students);
	}

	public void fetchStudentById() {
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

//		Student student = opt.orElseThrow(() -> new RuntimeException("Student Not found"));
//		System.out.println("=========Student==========");
//		System.out.println("sid   : "+student.getSid());
//		System.out.println("name  : "+student.getName());
//		System.out.println("phone : "+student.getPhone());
	}

	public void sortStudents() {
		System.out.println("Enter parameter to Sort");
		String param = sc.next();
		List<Student> students = repo.findAll(Sort.by(param).descending());

		printStudents(students);

	}

	public void filterStudents() {
		System.out.println("filtering the records");

		Student st = new Student();
		st.setName("Penga");
		st.setPhone(123L);

		// Query By example
		Example<Student> filter = Example.of(st);

		List<Student> all = repo.findAll(filter);

		printStudents(all);

	}

	public void printStudents(List<Student> all) {
		if (all != null) {
			System.out.println("============Students============");
			for (Student student : all) {
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
}
