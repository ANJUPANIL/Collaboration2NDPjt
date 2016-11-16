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

public class friends extends BaseDomain{
	
	@Id
	@Column
	@NotEmpty(message="Please enter a valid friend Id")
	private String fid;
	
	@Column
	@NotEmpty(message="Please enter a valid user")
	private String requestto;
	
	@Column
	@NotEmpty(message="Please enter a valid user")
	private String userid;
	
	@Column
	@NotEmpty(message="Please enter a valid friend request date")
	private String requesteddate;
	
	@Column
	@NotEmpty(message="Please enter a valid friend followers")
	private String follow;
	
	@Column
	@NotEmpty
	private String status;
	
	
	public String getFid() {
		return fid;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}



	public String getRequestto() {
		return requestto;
	}


	public void setRequestto(String requestto) {
		this.requestto = requestto;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getRequesteddate() {
		return requesteddate;
	}


	public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
	}


	public String getFollow() {
		return follow;
	}


	public void setFollow(String follow) {
		this.follow = follow;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public friends() {
		this.fid = "FRND" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

}
