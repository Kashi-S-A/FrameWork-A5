package com.mvc.FirstMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstMvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(FirstMvcApplication.class, args);
	}

}
