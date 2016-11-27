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
public class jobbookmark extends BaseDomain{
	@Id
	@Column
	@NotEmpty(message="Please enter a valid friend Id")
	private String id;
	
	@Column
	@NotEmpty(message="Please enter a valid friend Id")
	private String job_id;
	
	
	@Column
	@NotEmpty(message="Please enter a valid friend Id")
	private String user_id;
	
	@Column
	@NotEmpty(message="Please enter a valid friend Id")
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public jobbookmark() {
		this.id = "JB" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

}
