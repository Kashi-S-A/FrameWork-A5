package com.ss.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.dto.LoginDTO;
import com.ss.entity.User;
import com.ss.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {

		Optional<User> opt = userRepository.findByUsername(user.getUsername());
		if (opt.isPresent()) {
			return ResponseEntity.badRequest().body("Already Registered!!!!!");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User saved = userRepository.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).body("user registered with un : " + saved.getUsername());
	}

	@PostMapping("/login")
	public ResponseEntity<String> getMethodName(@RequestBody LoginDTO dto) {

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.getUsername(),
				dto.getPassword());

		Authentication authentication = authenticationManager.authenticate(authToken);

		if (authentication.isAuthenticated()) {
			return ResponseEntity.ok("Logged In successfully");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
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
