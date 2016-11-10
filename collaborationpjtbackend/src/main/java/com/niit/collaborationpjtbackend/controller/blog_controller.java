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

import com.niit.collaborationpjtbackend.dao.blogmaster_dao;
import com.niit.collaborationpjtbackend.model.blogmaster;
import com.niit.collaborationpjtbackend.model.jobcarrier;

@RestController
public class blog_controller {
	
	@Autowired
	blogmaster_dao blogdao;
	
	@RequestMapping(value="/allblogs", method=RequestMethod.GET)
	public ResponseEntity<List<blogmaster>> listallusers()
	{
		List<blogmaster> blogs =blogdao.showallblog();
		if(blogs.size()==0)
		{
			return new ResponseEntity<List<blogmaster>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<blogmaster>>(blogs,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/allpendingblogs", method=RequestMethod.GET)
	public ResponseEntity<List<blogmaster>> listallpendingblogs()
	{
		List<blogmaster> blogs =blogdao.showallpendinblog();
		System.out.println("Pending blog user id"+blogs.get(0).getUser());
		if(blogs.size()==0)
		{
			return new ResponseEntity<List<blogmaster>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<blogmaster>>(blogs,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/saveblog/", method=RequestMethod.POST)
	public ResponseEntity<blogmaster> createuser(@RequestBody blogmaster blog,HttpSession session)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String cdate=dateFormat.format(date);
		blog.setBlog_date(cdate);
		blog.setStatus("Newpost");
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");
		blog.setUser(loggedInUserId);
		blogdao.saveblog(blog);
		blog.setErrorMessage("Blog posted successfully.....");
		return new ResponseEntity<blogmaster>(blog,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updateblog",method=RequestMethod.PUT)
	public ResponseEntity<blogmaster> updateuser(@RequestBody blogmaster blog)
	{
		//System.out.println("Update user :" + id);
		
		System.out.println("Update user name :" + blog.getBlog_title());
		blogdao.updateblog(blog);
		return new ResponseEntity<blogmaster>(blog,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteblog/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<blogmaster> deleteuser(@PathVariable("id") String id)
	{
		
		blogdao.deleteblog(id);
		
		return new ResponseEntity<blogmaster>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/adminapprove/{id}", method=RequestMethod.PUT)
	public ResponseEntity<blogmaster> adminapprove(@PathVariable("id") String id)
	{
		
		blogdao.adminapprove(id);
		System.out.println("Approved blog  " + id);
		return new ResponseEntity<blogmaster>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/adminreject/{id}", method=RequestMethod.PUT)
	public ResponseEntity<blogmaster> adminreject(@PathVariable("id") String id)
	{
		
		blogdao.adminreject(id);
		System.out.println("Rejected blog  " + id);
		return new ResponseEntity<blogmaster>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/showblogbyid/{id}", method=RequestMethod.GET)
	public ResponseEntity<blogmaster> getuser(@PathVariable("id") String id)
	{
		
		blogmaster blog =blogdao.getblogbyid(id);
		 
		return new ResponseEntity<blogmaster>(blog,HttpStatus.OK);
	}
	

}
