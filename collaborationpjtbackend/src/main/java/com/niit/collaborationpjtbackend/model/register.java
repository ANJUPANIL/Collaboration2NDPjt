package com.niit.collaborationpjtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Register")
@Component
public class register extends BaseDomain {
	
	@Id
	@Column
	@NotEmpty(message="Please enter your email Id")
	@Email(message = "Invalid Email..please enter a valid Email address.")
	private String user_id;
	
	@Column
	@NotEmpty(message="Please enter your first name")
	private String fname;
	
	@Column
	@NotEmpty(message="Please enter your middle name")
	private String mname;
	
	@Column
	@NotEmpty(message="Please enter your last name")
	private String lname;
	
	@Column
	@NotEmpty(message="Please enter your date of birth")
	private String dob;
	
	@Column
	@NotEmpty(message="Please enter your address")
	private String address;
	
	@Column
	@NotEmpty(message="Please enter your contact number")
	@Size(min=10,max=10,message = "Enter 10 digit contact number")
	private String contact;
	
	
	
	@Column
	@NotEmpty(message="Please enter your password")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;
	
	@Column
	@NotEmpty(message="Please enter your profile created date")
	private String createddate;
	
	@Column
	private String modifieddate;
	
	@Column
	private String userimage;
	
	public role getUser_role() {
		return user_role;
	}

	public void setUser_role(role user_role) {
		this.user_role = user_role;
	}

	@OneToOne
	@JoinColumn(name="role_id")
	private role user_role;
	
	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getUserimage() {
		return userimage;
	}

	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	@Column
	@NotEmpty
	private String status;

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
