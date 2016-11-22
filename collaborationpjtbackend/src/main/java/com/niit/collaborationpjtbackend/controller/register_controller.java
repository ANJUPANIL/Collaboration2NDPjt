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

import com.niit.collaborationpjtbackend.dao.register_dao;
import com.niit.collaborationpjtbackend.model.blogmaster;
import com.niit.collaborationpjtbackend.model.register;

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
	
	@RequestMapping(value="/allpendingregister", method=RequestMethod.GET)
	public ResponseEntity<List<register>> listallpendingusers()
	{
		List<register> users =regdao.pendingregister();
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
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			String cdate=dateFormat.format(date);
			user.setCreateddate(cdate);
			user.setStatus("New");
			user.setUseronline("false");
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
		System.out.println(" And FreindID " +id);
		String f=id + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And FreindID " +f);
		
		//register u=regdao.getuserdetailsbyid(f);
		register regobj=regdao.getuserdetailsbyid(f);
		if(regobj==null)
		{
			regobj =new register();
			regobj.setErrorMessage("User does not exist with id : "+regobj.getUser_id());
			System.out.println("user not found");
			return new ResponseEntity<register>(regobj,HttpStatus.NOT_FOUND);
		}
		System.out.println("user  found " + regobj.getFname());
		regobj.setErrorMessage("true");
		return new ResponseEntity<register>(regobj,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/authenticate", method=RequestMethod.POST)
	public ResponseEntity<register> authenticate(@RequestBody register user,HttpSession session)
	{
		System.out.println("Authenicate "+user.getUser_id());
		if(regdao.isvaliduser(user.getUser_id(), user.getPassword())==false)
		{
			user =new register();
			user.setErrorMessage("Invalid credentials..Please enter valid credentials");
			System.out.println("Invalid credentials..Please enter valid credentials");
			
		}
		else
		{
		    register user1=regdao.getuserdetailsbyid(user.getUser_id());
		    if(user1.getStatus().equals("Approved"))
		    {
		    	user.setFname(user1.getFname());
			    user.setRole(user1.getRole());
			    user.setUseronline("true");
				System.out.println("Valid user..."+user.getFname()+"Successfully login");
				session.setAttribute("loggedInUser", user);
				session.setAttribute("loggedInUserId", user.getUser_id());
		    }
		    else
		    {
		    	user.setErrorMessage("Your registration is not get approved...Please try again later");
		    }
		    
		}
		 
		return new ResponseEntity<register>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	public ResponseEntity<register> logout(HttpSession session)
	{
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");
		//setoffLine(loggedInUserId)
		session.invalidate();
		System.out.println("Logout user successfully");
		return new ResponseEntity<register>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/registerapprove/{id}", method=RequestMethod.PUT)
	public ResponseEntity<register> adminapprove(@PathVariable("id") String id)
	{
		
		System.out.println("Approved register" + id);
		String rid=id + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And RID " +rid);
	
		
		regdao.registerapprove(rid);
		
		return new ResponseEntity<register>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/registerreject/{id}", method=RequestMethod.PUT)
	public ResponseEntity<register> adminreject(@PathVariable("id") String id)
	{
		System.out.println("Approved register" + id);
		String rid=id + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And RID " +rid);
	
		regdao.registerreject(rid);
		System.out.println("Rejected register" + id);
		return new ResponseEntity<register>(HttpStatus.OK);
		
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
