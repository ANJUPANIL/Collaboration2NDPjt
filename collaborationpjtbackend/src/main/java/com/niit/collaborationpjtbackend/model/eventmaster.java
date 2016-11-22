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
	private String event_image;
	
	public String getEvent_id() {
		return event_id;
	}




	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}




	public String getEvent_title() {
		return event_title;
	}




	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}




	public String getEvent_content() {
		return event_content;
	}




	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}




	public String getEvent_venue() {
		return event_venue;
	}




	public void setEvent_venue(String event_venue) {
		this.event_venue = event_venue;
	}




	public String getEvent_date() {
		return event_date;
	}




	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}




	public String getEvent_image() {
		return event_image;
	}




	public void setEvent_image(String event_image) {
		this.event_image = event_image;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	@Column
	@NotEmpty
	private String status;
	
	

	
	public eventmaster() {
		this.event_id = "EVNT" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	

}
