package com.niit.collaborationpjtbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationpjtbackend.dao.register_dao;
import com.niit.collaborationpjtbackend.model.register;
import com.niit.collaborationpjtbackend.model.role;

@RestController
public class register_controller {
	@Autowired
	register_dao regdao;
	
	
	@RequestMapping(value="/allusers", method=RequestMethod.GET)
	public ResponseEntity<List<register>> listallusers()
	{
		List<register> users =regdao.alluserdetails();
		if(users.isEmpty())
		{
			return new ResponseEntity<List<register>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<register>>(users,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/saveuser/", method=RequestMethod.POST)
	public ResponseEntity<register> createuser(@RequestBody register user)
	{
		if(regdao.getuserdetailsbyid(user.getUser_id())==null)
		{
			regdao.saveuserdetails(user);
			return new ResponseEntity<register>(user,HttpStatus.OK);
		}
		user.setErrorMessage("User already exist with id : " + user.getUser_id()); 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<register> updateuser(@PathVariable("id") String id,@RequestBody register user)
	{
		System.out.println("Update user :" + id);
		if(regdao.getuserdetailsbyid(id)==null)
		{
			user =new register();
			user.setErrorMessage("User does not exist with id : "+ id);
			return new ResponseEntity<register>(user,HttpStatus.NOT_FOUND);
		}
		System.out.println("Update user name :" + user.getFname());
		regdao.updateuserdetails(user);
		 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<register> deleteuser(@PathVariable("id") String id)
	{
		register user=regdao.getuserdetailsbyid(id);
		if(user==null)
		{
			user =new register();
			user.setErrorMessage("User does not exist with id : "+user.getUser_id());
			return new ResponseEntity<register>(user,HttpStatus.NOT_FOUND);
		}
		regdao.deleteuserdetails(id);
		 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public ResponseEntity<register> getuser(@PathVariable("id") String id)
	{
		register user=regdao.getuserdetailsbyid(id);
		if(user==null)
		{
			user =new register();
			user.setErrorMessage("User does not exist with id : "+user.getUser_id());
			return new ResponseEntity<register>(user,HttpStatus.NOT_FOUND);
		}
		 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/authenticate", method=RequestMethod.POST)
	public ResponseEntity<register> authenticate(@RequestBody register user,HttpSession session)
	{
		System.out.println("Authenicate "+user.getUser_id());
		if(regdao.isvaliduser(user.getUser_id(), user.getPassword())==false)
		{
			user =new register();
			user.setErrorMessage("Invalid credentials..Please enter valid credentials");
			
		}
		else
		{
			session.setAttribute("loggedInUser", user);
			session.setAttribute("loggedInUserId", user.getUser_id());
		}
		 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	
	
/*	
	@RequestMapping(value="/saverole", method=RequestMethod.POST)
	public ResponseEntity<role> saverole(@RequestBody role r)
	{
		System.out.println("save role");
		regdao.saverole(r);
		System.out.println(r.getRole_id());
		return new ResponseEntity<role>(r,HttpStatus.OK);
	}
	
	*/
	
	
	
	

}
