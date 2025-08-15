package com.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.entity.User;
import com.ss.repository.UserRepository;

@Service
public class EndUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbUser = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
		
		return org.springframework.security.core.userdetails.User
															.withUsername(dbUser.getUsername())
															.password(dbUser.getPassword())
															.roles(dbUser.getRole())
															.build();
	}

}
