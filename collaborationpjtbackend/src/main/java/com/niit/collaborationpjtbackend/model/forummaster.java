package com.niit.collaborationpjtbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Forummaster")
@Component
public class forummaster {
	@Id
	@Column
	@NotEmpty(message="Please enter a valid forum Id")
	private String forum_id;
	
	@Column
	@NotEmpty(message="Please enter a valid forum title")
	private String forum_title;
	
	public String getForum_type() {
		return forum_type;
	}

	public void setForum_type(String forum_type) {
		this.forum_type = forum_type;
	}

	@Column
	@NotEmpty(message="Please enter a valid forum content")
	private String forum_content;

	@Column
	@NotEmpty(message="Please enter a valid forum date")
	private String forum_date;
	
	@Column
	@NotEmpty(message="Please enter a valid forum type")
	private String forum_type;
	
	public String getForum_id() {
		return forum_id;
	}

	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_title() {
		return forum_title;
	}

	public void setForum_title(String forum_title) {
		this.forum_title = forum_title;
	}

	public String getForum_content() {
		return forum_content;
	}

	public void setForum_content(String forum_content) {
		this.forum_content = forum_content;
	}

	public String getForum_date() {
		return forum_date;
	}

	public void setForum_date(String forum_date) {
		this.forum_date = forum_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public register getUser() {
		return user;
	}

	public void setUser(register user) {
		this.user = user;
	}

	@Column
	@NotEmpty
	private String status;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private register user;

	public forummaster() {
		this.forum_id = "BLG" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
