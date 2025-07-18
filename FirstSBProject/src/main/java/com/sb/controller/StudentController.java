package com.sb.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;
import com.sb.exception.StudentNotFoundException;
import com.sb.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/get")
	public ResponseEntity<?> fetchStudent(@RequestParam(name = "sid") Long id) {
//		String a = null;
//		a.charAt(0);
		throw new StudentNotFoundException("student does not exist");
//		return studentService.getById(id);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleArithmeticException(Exception exception) {
//		System.out.println("Local handler");
//		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//	}

	@GetMapping("/all")
	public List<StudentResponseDTO> fetchStudent(@RequestParam Integer pageNumber) {
		return studentService.findAll(pageNumber);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid StudentDTO studentDTO) {
		return studentService.saveStudent(studentDTO);
	}

	@PutMapping("/update/{sid}/{name}")
	public String updateName(@PathVariable(name = "sid") Long id, @PathVariable String name) {
		return studentService.updateName(id, name);
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam Long sid) {
		return studentService.deleteStudent(sid);
	}

	@GetMapping(value = "/content", produces = { 
												 "application/xml",
												 "application/json" 
												}, 
									consumes = {
												 "application/xml",
												 "application/json"
												}
	             )
	public StudentDTO getMethodName(@RequestBody StudentDTO studentDTO) {
		System.out.println(studentDTO);
		return studentDTO;
	}

}