package com.niit.collaborationpjtbackend.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.niit.collaborationpjtbackend.model.forummaster;

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
	public ResponseEntity<forummaster> createuser(@RequestBody forummaster forum,HttpSession session)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String cdate=dateFormat.format(date);
		forum.setForum_date(cdate);
		forum.setStatus("Newpost");
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");
		forum.setUser_id(loggedInUserId);
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
	
	@RequestMapping(value="/showforumbyid/{id}", method=RequestMethod.GET)
	public ResponseEntity<forummaster> getuser(@PathVariable("id") String id)
	{
		
		forummaster forum =forumdao.getforumbyid(id);
		 
		return new ResponseEntity<forummaster>(forum,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/forumlike/{id}",method=RequestMethod.PUT)
	public ResponseEntity<forummaster> forumlike(@PathVariable("id") String id)
	{
		System.out.println("forum like :" + id);
		forumdao.forumlikes(id);
		return new ResponseEntity<forummaster>(HttpStatus.OK);
	}

	@RequestMapping(value="/forumdislike/{id}",method=RequestMethod.PUT)
	public ResponseEntity<forummaster> forumdislike(@PathVariable("id") String id)
	{
		System.out.println("forum dislike :" + id);
		forumdao.forumdislikes(id);
		return new ResponseEntity<forummaster>(HttpStatus.OK);
	}

}
