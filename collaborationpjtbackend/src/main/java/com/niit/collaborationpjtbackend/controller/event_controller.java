package com.niit.collaborationpjtbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationpjtbackend.dao.eventmaster_dao;
import com.niit.collaborationpjtbackend.model.eventmaster;

@RestController
public class event_controller {
	
	@Autowired
	eventmaster_dao eventdao;
	
	@RequestMapping(value="/allevents", method=RequestMethod.GET)
	public ResponseEntity<List<eventmaster>> listallusers()
	{
		List<eventmaster> events =eventdao.showallevent();
		if(events.size()==0)
		{
			return new ResponseEntity<List<eventmaster>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<eventmaster>>(events,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/saveevent/", method=RequestMethod.POST)
	public ResponseEntity<eventmaster> createuser(@RequestBody eventmaster event)
	{
		
		System.out.println("Event save");
			event.setStatus("Active");
		
			eventdao.saveevent(event);
			event.setErrorMessage("event posted successfully.....");
			return new ResponseEntity<eventmaster>(event,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updateevent",method=RequestMethod.PUT)
	public ResponseEntity<eventmaster> updateuser(@RequestBody eventmaster event)
	{
		//System.out.println("Update user :" + id);
		
		//System.out.println("Update user name :" + event.getevent_title());
		eventdao.updateevent(event);
		return new ResponseEntity<eventmaster>(event,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteevent/{id}", method=RequestMethod.PUT)
	public ResponseEntity<eventmaster> deleteuser(@PathVariable("id") String id)
	{
		
		eventdao.deleteevent(id);
		
		return new ResponseEntity<eventmaster>(HttpStatus.OK);
		
	}
	

}
