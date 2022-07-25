package com.lokanov.project_lokanov360.controller;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lokanov.project_lokanov360.repository.UserRepository;
import com.lokanov.project_lokanov360.service.UserPrinciple;
import com.lokanov.project_lokanov360.repository.RoleRepository;
import com.lokanov.project_lokanov360.config.JwtToken;
import com.lokanov.project_lokanov360.dto.JwtResponse;
import com.lokanov.project_lokanov360.dto.LoginDto;
import com.lokanov.project_lokanov360.dto.UserDto;
import com.lokanov.project_lokanov360.entity.Role;
import com.lokanov.project_lokanov360.entity.User;
import com.lokanov.project_lokanov360.enums.RoleName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtToken jwtToken;
	
	JavaMailSenderImpl ja = new JavaMailSenderImpl();

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto)  throws MessagingException {
		if (userRepository.findByEmail(userDto.getEmail()) != null) {
			return new ResponseEntity<String>("Fail -> The user is already exist !", HttpStatus.BAD_REQUEST);
		}

		User user = new User(userDto.getFirstName(), userDto.getName(), encoder.encode(userDto.getPassword()),
				userDto.getEmail());

		
		switch (userDto.getRole()) {
		case "admin":
			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Admin Role not find."));
			user.setRole(adminRole);
		
			break;
		default:
			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			user.setRole(userRole);
		}
		System.out.println(userDto.getRole());
		userRepository.save(user);
		
         Properties properties = createConfiguration();
		
		Smtpauthenticator smtpauthenticator = new Smtpauthenticator();
		
		Session session = Session.getDefaultInstance(properties,smtpauthenticator);
		
		MimeMessage message = new MimeMessage(session);

		
		message.setFrom(new InternetAddress("email"));
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));
		message.setText("Merci "+user.getFirstName()+"pour l'attention nous vous repondron tres bientot" );
		
		
    
		return ResponseEntity.ok().body("User registered successfully!");
	}
	
	private  class Smtpauthenticator extends Authenticator{
		 private String username = "email";
	        private String password = "password";
		
	        public PasswordAuthentication passwordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

	
	private static Properties createConfiguration() {
	    return new Properties() {
	        {
	            put("mail.smtp.auth", "true");
	            put("mail.smtp.host", "smtp.gmail.com");
	            put("mail.smtp.port", "587");
	            put("mail.smtp.password", "password");
	            put("mail.smtp.starttls.enable", "true");
	           put("mail.smtp.user","email");
	        }
	    };
	 }
	

	@PostMapping("/signin")
	
	public ResponseEntity<?> authenticate(@RequestBody LoginDto loginRequest) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		final String token = jwtToken.generateToken(authentication);

		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
		System.out.println(jwtToken.getUserRoleFromToken(token));
		return ResponseEntity.ok(new JwtResponse(token, jwtToken.getUsernameFromToken(token), userPrincipal.getUser(),
				userPrincipal.getAuthorities()));
	}
	
	@PostMapping("/connect")
	
	public ResponseEntity<?> connection( String email, String password) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(email,password));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		final String token = jwtToken.generateToken(authentication);

		UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(token, jwtToken.getUsernameFromToken(token), userPrincipal.getUser(),
				userPrincipal.getAuthorities()));

	}
}