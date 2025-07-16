package com.sb.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public String saveStudent(StudentDTO studentDTO) {
		Optional<Student> opt = studentRepository.findByEmail(studentDTO.getEmail());

		if (opt.isPresent()) {
			return "already registered ";
		} else {
			Student student = new Student();

			BeanUtils.copyProperties(studentDTO, student);

			studentRepository.save(student);
			return "registered successfully";
		}
	}

	@Override
	public StudentResponseDTO getById(Long id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			Student student = opt.get();
			StudentResponseDTO response = new StudentResponseDTO();
			BeanUtils.copyProperties(student, response);
			return response;
		}
		return null;
	}

}
