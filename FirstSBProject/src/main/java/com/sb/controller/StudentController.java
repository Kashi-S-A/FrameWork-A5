package com.sb.controller;

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

import com.sb.dto.StudentDTO;
import com.sb.dto.StudentResponseDTO;
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
	public StudentResponseDTO fetchStudent(@RequestParam(name = "sid") Long id) {
		return studentService.getById(id);
	}

	@GetMapping("/all")
	public void fetchStudent() {
		// TODO: logic fetch
		return;
	}

	@PostMapping("/save")
	public String save(@RequestBody @Valid StudentDTO studentDTO) {
		return studentService.saveStudent(studentDTO);
	}

	@PutMapping("/update/{sid}/{name}")
	public String updateName(@PathVariable(name = "sid") Integer id, @PathVariable String name) {
		return "Student not found";
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam Integer sid) {
		return "Student not found";
	}

	@GetMapping("/head")
	public String gotData(@RequestHeader String secretKey) {
		System.out.println(secretKey);
		return "read the data from headers";
	}

}