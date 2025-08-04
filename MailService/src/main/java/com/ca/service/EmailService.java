package com.ca.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);
	}

	@Autowired
	private TemplateEngine engine;

	public void sendEmailWithAtch(String to, String subject, String user) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);// to add attachments the use true

		Context context = new Context();
		context.setVariable("username", user);

		String body = engine.process("welcome-page", context);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);// if body contains html code then pass true

		helper.addAttachment("app-info", new File("C:\\Users\\asus\\Downloads\\PresentationApp.txt"));

		javaMailSender.send(mimeMessage);

		System.out.println("mail sent with template");
	}
}
