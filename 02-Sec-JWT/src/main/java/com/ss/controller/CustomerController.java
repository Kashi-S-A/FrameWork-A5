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
import org.springframework.web.bind.annotation.RestController;

import com.ss.entity.Customer;
import com.ss.repository.CustomerRepository;
import com.ss.service.JwtService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to app";
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer) {

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(customer.getEmail(),
				customer.getPassword());

		try {
			Authentication authentication = authenticationManager.authenticate(authToken);

			if (authentication.isAuthenticated()) {
				String jwtToken = jwtService.generateToken(customer.getEmail());

				return ResponseEntity.ok("Login Successfull and use token for further req :" + jwtToken);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().body("Invalid Credentials");
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer customer) {

		Optional<Customer> opt = customerRepository.findByEmail(customer.getEmail());

		if (opt.isPresent()) {
			return ResponseEntity.badRequest().body("Already Registered");
		}

		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		Customer saved = customerRepository.save(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body("user with email " + saved.getEmail()+" is registered");
	}

}
