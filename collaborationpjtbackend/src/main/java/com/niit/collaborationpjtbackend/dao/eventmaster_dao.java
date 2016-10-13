package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.eventmaster;



public interface eventmaster_dao {

	public void saveevent(eventmaster event);
	
	public List<eventmaster> showallevent();
	
	public eventmaster geteventbyid(String id);
	
	public void updateevent(eventmaster event);
	
	public void deleteevent(String id);
}
