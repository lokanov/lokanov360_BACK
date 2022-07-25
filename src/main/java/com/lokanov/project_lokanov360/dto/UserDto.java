package com.lokanov.project_lokanov360.dto;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lokanov.project_lokanov360.entity.Role;

public class UserDto {
	
	
	
	private Long   id;
	private String firstName;
	private String name;
	private String password;
	private String email;
	private String role;
	
	
	
	
	public UserDto() {
		super();
	}

	
	public UserDto(Long id, String firstName, String name, String password, String email, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
