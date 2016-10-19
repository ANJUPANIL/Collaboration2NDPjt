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

import com.niit.collaborationpjtbackend.dao.forummaster_dao;
import com.niit.collaborationpjtbackend.model.forummaster;
import com.niit.collaborationpjtbackend.model.register;

@RestController
public class forum_controller {
	
	@Autowired
	forummaster_dao forumdao;
	
	@RequestMapping(value="/allforums", method=RequestMethod.GET)
	public ResponseEntity<List<forummaster>> listallusers()
	{
		List<forummaster> forums =forumdao.showallforum();
		if(forums.size()==0)
		{
			return new ResponseEntity<List<forummaster>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<forummaster>>(forums,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/saveforum/", method=RequestMethod.POST)
	public ResponseEntity<forummaster> createuser(@RequestBody forummaster forum)
	{
		
			forumdao.saveforum(forum);
			forum.setErrorMessage("forum posted successfully.....");
			return new ResponseEntity<forummaster>(forum,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updateforum",method=RequestMethod.PUT)
	public ResponseEntity<forummaster> updateuser(@RequestBody forummaster forum)
	{
		//System.out.println("Update user :" + id);
		
		System.out.println("Update user name :" + forum.getForum_title());
		forumdao.updateforum(forum);
		return new ResponseEntity<forummaster>(forum,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteforum/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<forummaster> deleteuser(@PathVariable("id") String id)
	{
		
		forumdao.deleteforum(id);
		
		return new ResponseEntity<forummaster>(HttpStatus.OK);
		
	}
	

}
