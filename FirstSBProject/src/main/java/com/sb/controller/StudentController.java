package com.sb.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.util.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	static Set<Student> students = new HashSet<>();

	static {
		students.add(new Student(101, "Dinga", "dinga@gmail.com"));
		students.add(new Student(102, "Dingi", "dingi@gmail.com"));
		students.add(new Student(103, "Manga", "manga@gmail.com"));
		students.add(new Student(104, "Mangi", "mangi@gmail.com"));
		students.add(new Student(105, "Penga", "pengi@gmail.com"));
	}

	@GetMapping("/get")
	public Student fetchStudent(@RequestParam(name = "sid") Integer id) {
		System.out.println(id);
		for (Student student : students) {
			if (student.getSid() == id) {
				return student;
			}
		}
		return null;
	}

	@GetMapping("/all")
	public Set<Student> fetchStudent() {
		return students;
	}

	@PostMapping("/save")
	public String postMethodName(@RequestBody Student student) {
		students.add(student);
		System.out.println(student);
		return "Student is saved with sid : " + student.getSid();
	}

	@PutMapping("/update/{sid}/{name}")
	public String putMethodName(@PathVariable(name = "sid") Integer id, @PathVariable String name) {
		for (Student student : students) {
			if (student.getSid() == id) {
				student.setName(name);
				return "Student with id : " + id + " is update with new name : " + name;
			}
		}
		return "Student not found";
	}

	@DeleteMapping("/delete")
	public String deleteMethodName(@RequestParam Integer sid) {
		for (Student student : students) {
			if (student.getSid() == sid) {
				students.remove(student);
				return "Student with id : " + sid + " is deleted";
			}
		}
		return "Student not found";
	}

	@GetMapping("/head")
	public String gotData(@RequestHeader String secretKey) {
		System.out.println(secretKey);
		return "read the data from headers";
	}

}