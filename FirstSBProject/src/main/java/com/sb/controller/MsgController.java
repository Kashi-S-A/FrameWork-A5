package com.sb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

	@GetMapping("/get")
	public String getMethod() {
		System.out.println(" get Triggered");
		return "Data fetched";
	}

	@PostMapping("/post")
	public String postMethod() {
		System.out.println(" post Triggered");
		return "Data saved";
	}

	@PutMapping("/up")
	public String upMethod() {
		System.out.println("put Triggered");
		return "Data updated";
	}

	@DeleteMapping("/del")
	public String deleteMethod() {
		System.out.println("Delete Triggered");
		return "Data Deleted";
	}

}
