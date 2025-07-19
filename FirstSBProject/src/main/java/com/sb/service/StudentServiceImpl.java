package com.sb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.dao.StudentDAO;
import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;
import com.sb.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public StudentServiceImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public ResponseEntity<String> saveStudent(StudentDTO studentDTO) {
		Optional<Student> opt = studentDAO.findByEmail(studentDTO.getEmail());

		ResponseEntity<String> rs = null;

		if (opt.isPresent()) {
			rs = new ResponseEntity<String>("already registered ", HttpStatus.BAD_REQUEST);
		} else {
			Student student = new Student();

			BeanUtils.copyProperties(studentDTO, student);

			studentDAO.save(student);
			rs = new ResponseEntity<String>("registered successfully", HttpStatus.CREATED);
		}
		return rs;
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Student student = studentDAO.findById(id);
		StudentResponseDTO response = new StudentResponseDTO();
		BeanUtils.copyProperties(student, response);
		return new ResponseEntity<StudentResponseDTO>(response, HttpStatus.OK);
	}

	@Override
	public List<StudentResponseDTO> findAll(Integer pageNumber) {

		List<Student> all = studentDAO.findAll(pageNumber);

		List<StudentResponseDTO> students = new ArrayList<>();

		for (Student student : all) {
			StudentResponseDTO dto = new StudentResponseDTO();
			BeanUtils.copyProperties(student, dto);
			students.add(dto);
		}

		return students;
	}

	@Override
	public String updateName(Long id, String name) {
		Student student = studentDAO.findById(id);
		student.setName(name);
		studentDAO.save(student);
		return "student name update to : " + name;
	}

	@Override
	public String deleteStudent(Long sid) {
		Student student = studentDAO.findById(sid);
		studentDAO.delete(student);
		return "Student Deleted";
	}

}
