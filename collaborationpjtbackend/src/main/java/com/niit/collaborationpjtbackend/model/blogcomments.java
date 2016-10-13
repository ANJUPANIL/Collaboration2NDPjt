package com.niit.collaborationpjtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class blogcomments {
	
	@Id
	@Column
	@GeneratedValue
	private int cid;
	
	@Column
	@NotEmpty(message="Please enter a valid blog comment")
	private String textcomment;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private register user;
	
	@OneToOne
	@JoinColumn(name="blog_id")
	private blogmaster blog;

	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTextcomment() {
		return textcomment;
	}

	public void setTextcomment(String textcomment) {
		this.textcomment = textcomment;
	}

	public register getUser() {
		return user;
	}

	public void setUser(register user) {
		this.user = user;
	}

	public blogmaster getBlog() {
		return blog;
	}

	public void setBlog(blogmaster blog) {
		this.blog = blog;
	}
	
	

	
	
	

}
