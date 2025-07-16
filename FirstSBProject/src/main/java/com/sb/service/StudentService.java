package com.sb.service;

import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;

public interface StudentService {

	String saveStudent(StudentDTO studentDTO);

	StudentResponseDTO getById(Long id);

}
