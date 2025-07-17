package com.sb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;
import com.sb.entity.Student;
import com.sb.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public ResponseEntity<String> saveStudent(StudentDTO studentDTO) {
		Optional<Student> opt = studentRepository.findByEmail(studentDTO.getEmail());

		ResponseEntity<String> rs = null;

		if (opt.isPresent()) {
			rs = new ResponseEntity<String>("already registered ", HttpStatus.BAD_REQUEST);
		} else {
			Student student = new Student();

			BeanUtils.copyProperties(studentDTO, student);

			studentRepository.save(student);
			rs = new ResponseEntity<String>("registered successfully", HttpStatus.CREATED);
		}
		return rs;
	}

	@Override
	public ResponseEntity<?> getById(Long id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			Student student = opt.get();
			StudentResponseDTO response = new StudentResponseDTO();
			BeanUtils.copyProperties(student, response);
			return new ResponseEntity<StudentResponseDTO>(response, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	@Override
	public List<StudentResponseDTO> findAll(Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 10);

		List<Student> all = studentRepository.findAll(pageable).toList();

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
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			Student student = opt.get();
			student.setName(name);
			studentRepository.save(student);
			return "student name update to : " + name;
		}
		return "Student not found";
	}

	@Override
	public String deleteStudent(Long sid) {
		Optional<Student> opt = studentRepository.findById(sid);
		if (opt.isPresent()) {
			studentRepository.delete(opt.get());
			return "Deleted Successfully";
		}
		return "Student not found";
	}

}
