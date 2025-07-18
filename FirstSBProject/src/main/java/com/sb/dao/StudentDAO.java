package com.sb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.sb.entity.Student;
import com.sb.exception.StudentNotFoundException;
import com.sb.repository.StudentRepository;

@Repository
public class StudentDAO {

	private StudentRepository studentRepository;

	public StudentDAO(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student findById(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not exists"));
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void delete(Student student) {
		studentRepository.delete(student);
	}

	public Optional<Student> findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	public List<Student> findAll(Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
		return studentRepository.findAll(pageable).toList();
	}
}
