package com.ca.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.ca.enums.Course;

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

	public void sendConfirmMail(String to, String name, Course course) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);// to add attachments the use true

		Context context = new Context();
		context.setVariable("userName", name);
		context.setVariable("course", course);

		String body = engine.process("enquiry-page", context);

		helper.setTo(to);
		helper.setSubject("Enquiry Recieved");
		helper.setText(body, true);// if body contains html code then pass true

		javaMailSender.send(mimeMessage);

		System.out.println("mail sent to " + to);
	}
}
