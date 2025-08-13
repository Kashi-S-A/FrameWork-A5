package com.ss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

	@GetMapping("/register") 
	public String register() {
		return "Register Page!!!!!!!";
	}

	@GetMapping("/admin")
	public String admin() {
		return "Hi from ADMIN!!!!!!";
	}

	@GetMapping("/user")
	public String user() {
		return "Hi From USER!!!!!!!";
	}

}
