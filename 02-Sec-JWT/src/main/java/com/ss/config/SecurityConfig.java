package com.ss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ss.filter.AppFilter;
import com.ss.service.CustomerService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AppFilter appFilter;

	@Autowired
	private CustomerService customerService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvide= new DaoAuthenticationProvider(customerService);
		authProvide.setPasswordEncoder(passwordEncoder());
		return authProvide;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf->csrf.disable())
								.authorizeHttpRequests(auth->auth
										.requestMatchers("/login","/register").permitAll()
										.anyRequest().authenticated()
										)
								.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
								.authenticationProvider(authProvider())
								.addFilterBefore(appFilter, UsernamePasswordAuthenticationFilter.class)
								.build();
	}
}
