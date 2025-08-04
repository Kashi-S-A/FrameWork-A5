package com.ca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ca.service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class MailServiceApplication {

	public static void main(String[] args) throws MessagingException {
		ConfigurableApplicationContext run = SpringApplication.run(MailServiceApplication.class, args);

		EmailService service = run.getBean(EmailService.class);

		String to = "iqbal74983@gmail.com";
		String subject = "About attendence";
		String body = "Dear Student " + "Your attendence is not reaching the required %  ,"
				+ " i.e 85% attendence is mandatory, so you have meet HR/Respective Class Teacher" + "Thank You";

//		service.sendEmail(to, subject, body);

		String user = "Iqbal";

		service.sendEmailWithAtch(to, "Account Registration Email In Counselor App", user);
	}

}
