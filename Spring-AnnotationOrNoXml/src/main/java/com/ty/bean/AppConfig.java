package com.ty.bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.ty.bean")
public class AppConfig {

	@Bean
	@Scope(value = "prototype")
	public List<String> getSubjects() {
		return Arrays.asList("HTML", "JAVA", "Spring Boot");
	}

	@Bean(value = "myAddress")
	public Address getAddress() {
		Address a = new Address();
		a.setCountry("India");
		a.setState("Maharashtra");
		a.setZipcode(600100L);
		return a;
	}

	@Bean
	public Map<Integer, String> getItems() {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(101, "Dinga");
		m.put(102, "Dingi");
		m.put(103, "Manga");
		m.put(104, "Mangi");
		return m;
	}
}
