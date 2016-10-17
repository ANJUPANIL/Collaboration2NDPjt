package com.niit.collaborationpjtbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class jobcarrier {
	
	@Id
	@Column
	@NotEmpty(message="Please enter a valid job id")
	private String job_id;
	
	@Column
	@NotEmpty(message="Please enter a valid job title")
	private String job_title;
	
	@Column
	@NotEmpty(message="Please enter a valid job description")
	private String job_description;
	
	@Column
	@NotEmpty(message="Please enter a valid job role")
	private String job_role;
	
	
	@Column
	@NotEmpty(message="Please enter a valid job experience")
	private String job_experience;
	
	@Column
	@NotEmpty(message="Please enter a valid job location")
	private String job_location;
	
	@Column
	@NotEmpty(message="Please enter a valid job role")
	private String job_companyname;
	
	@Column
	@NotEmpty
	private String status;

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	public String getJob_experience() {
		return job_experience;
	}

	public void setJob_experience(String job_experience) {
		this.job_experience = job_experience;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public String getJob_companyname() {
		return job_companyname;
	}

	public void setJob_companyname(String job_companyname) {
		this.job_companyname = job_companyname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public jobcarrier() {
		this.job_id = "JOB" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	

}
