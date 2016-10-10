package com.niit.collaborationpjtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Userlogin")
@Component
public class userlogin {
	
	@Id
	@Column(name="user_id")
	@NotEmpty(message = "Please enter your Email address.")
	@Email(message = "Invalid Email..please enter a valid Email address.")
	private String user_id;
	
	@Column(name="password")
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column
	@NotEmpty
	private String role;

}
