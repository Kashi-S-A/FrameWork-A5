package com.sb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;

public interface StudentService {

	ResponseEntity<String> saveStudent(StudentDTO studentDTO);

	ResponseEntity<?> getById(Long id);

	List<StudentResponseDTO> findAll(Integer pageNumber);

	String updateName(Long id, String name);

	String deleteStudent(Long sid);

}
