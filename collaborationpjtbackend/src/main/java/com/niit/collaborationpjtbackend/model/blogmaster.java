package com.niit.collaborationpjtbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Blogmaster")
@Component
public class blogmaster {
	
	@Id
	@Column
	@NotEmpty(message="Please enter a valid blog Id")
	private String blog_id;
	
	@Column
	@NotEmpty(message="Please enter a valid blog title")
	private String blog_title;
	
	@Column
	@NotEmpty(message="Please enter a valid blog content")
	private String blog_content;
	
	@Column
	@NotEmpty(message="Please enter a valid blog date")
	private String blog_date;
	
	@Column
	@NotEmpty(message="Please enter a valid blog content")
	private String userid;
	
	
	@Column
	@NotEmpty
	private String status;

	

	public String getBlog_date() {
		return blog_date;
	}

	public void setBlog_date(String blog_date) {
		this.blog_date = blog_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}
	
	public blogmaster() {
		this.blog_id = "BLG" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	

}
