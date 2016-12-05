package com.niit.collaborationpjtbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


@Entity
@Table(name="Forumcomments")
@Component
public class forumcomments {
	
	@Id
	@Column
	@GeneratedValue
	private int cid;
	
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getForumid() {
		return forumid;
	}

	public void setForumid(String forumid) {
		this.forumid = forumid;
	}

	@Column
	@NotEmpty(message="Please enter a valid forum comment")
	private String textcomment;
	
	@Column
	@NotEmpty(message="Please enter a valid forum comment")
	private String userid;
	
	@Column
	@NotEmpty(message="Please enter a valid forum comment")
	private String forumid;


}
