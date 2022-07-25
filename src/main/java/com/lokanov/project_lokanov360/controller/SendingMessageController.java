package com.lokanov.project_lokanov360.controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.entity.Contact;






@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contact")
public class SendingMessageController {
JavaMailSenderImpl ja = new JavaMailSenderImpl();
	
	@ResponseBody
	@PostMapping("/sendEmail")
	public  ResponseEntity<?> createEmail(@RequestBody Contact contact ) throws MessagingException {
		
		System.out.println(contact.getMessage());
		
		Properties properties = createConfiguration();
		
		Smtpauthenticator smtpauthenticator = new Smtpauthenticator();
		
		Session session = Session.getDefaultInstance(properties,smtpauthenticator);
		
		MimeMessage message = new MimeMessage(session);

		
		message.setFrom(new InternetAddress("email"));
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(contact.getEmail()));
		message.setSubject(contact.getObject());
		
		message.setText("Merci "+contact.getNameAndSurname()+"pour l'attention nous vous repondron tres bientot" );
		
		Transport.send(message, "email","password");

		return ResponseEntity.ok("ok");
	}
	 private static Properties createConfiguration() {
		    return new Properties() {
		        {
		            put("mail.smtp.auth", "true");
		            put("mail.smtp.host", "smtp.gmail.com");
		            put("mail.smtp.port", "587");
		           // put("mail.smtp.password", "password");
		            put("mail.smtp.starttls.enable", "true");
		           // put("mail.smtp.user","email");
		        }
		    };
		 }
	 
	@PostMapping("/addMessage")
	//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PRESTA')")
	public ResponseEntity<Contact> add(@RequestBody Contact message) {
		Contact contact1 = new Contact(message.getNameAndSurname(), message.getEmail(), message.getphone(), message.getObject(), message.getMessage());
		
		return ResponseEntity.status(HttpStatus.OK).body(contact1);
	}

	
	private  class Smtpauthenticator extends Authenticator{
		 private String username = "email";
	        private String password = "password";
		
	        public PasswordAuthentication passwordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

}
