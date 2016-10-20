package com.niit.collaborationpjtbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Eventmaster")
@Component
public class eventmaster extends BaseDomain{
	
	@Id
	@Column
	@NotEmpty(message="Please enter a valid event Id")
	private String event_id;
	
	@Column
	@NotEmpty(message="Please enter a valid event title")
	private String event_title;
	
	@Column
	@NotEmpty(message="Please enter a valid event content")
	private String event_content;
	
	
	@Column
	@NotEmpty(message="Please enter a valid event venue")
	private String event_venue;
	
	@Column
	@NotEmpty(message="Please enter a valid event date")
	private String event_date;
	
	@Column
	@NotEmpty(message="Please enter a valid event image")
	private String event_image;
	
	@Column
	@NotEmpty
	private String status;
	
	

	public String getevent_date() {
		return event_date;
	}

	public void setevent_date(String event_date) {
		this.event_date = event_date;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getevent_id() {
		return event_id;
	}

	public void setevent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getevent_title() {
		return event_title;
	}

	public void setevent_title(String event_title) {
		this.event_title = event_title;
	}

	public String getevent_content() {
		return event_content;
	}

	public void setevent_content(String event_content) {
		this.event_content = event_content;
	}
	
	public eventmaster() {
		this.event_id = "EVNT" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	

}
