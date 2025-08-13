package com.ss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth
					.requestMatchers("/register").permitAll()
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/user").hasRole("USER")
				    .anyRequest()
				    .authenticated())
					.formLogin(login->login.permitAll())
					.logout(logout -> logout.permitAll());
		
		return httpSecurity.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withUsername("admin")
//									.password("{noop}admin123")//no password encoder
									.password(passwordEncoder().encode("admin123"))
									.roles("ADMIN")
									.build();
		
		UserDetails user = User.withUsername("user")
//									.password("{noop}user123")
									.password(passwordEncoder().encode("user123"))
									.roles("USER")
									.build();
		
		UserDetails userAdmin = User.withUsername("kashi")
									.password(passwordEncoder().encode("kashi123"))
									.roles("USER","ADMIN")
									.build();
		
		return new InMemoryUserDetailsManager(admin,user,userAdmin);		
	}
}
