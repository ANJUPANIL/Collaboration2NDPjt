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

import com.niit.collaborationpjtbackend.dao.friends_dao;
import com.niit.collaborationpjtbackend.model.friends;
import com.niit.collaborationpjtbackend.model.register;



@RestController
public class friends_controller {
	
	@Autowired
	friends_dao friendsdao;
	
	friends frd;
	
	
	@RequestMapping(value="/allfriends/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<friends>> listallusers(@PathVariable("id") String id)
	{
		List<friends> friends =friendsdao.showallfriends(id);
		if(friends.size()==0)
		{
			return new ResponseEntity<List<friends>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<friends>>(friends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/savefriends/{friendID}", method=RequestMethod.GET)
	public ResponseEntity<friends> createuser(@PathVariable("friendID") String friendID,HttpSession session)
	{	
		System.out.println("Freind save controller");
		System.out.println(" And FreindID " +friendID);
		String f=friendID + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And FreindID " +f);
		friends friends=new friends();
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String cdate=dateFormat.format(date);
		friends.setUserid(loggedInUserId);
		friends.setRequestto(f);
		friends.setRequesteddate(cdate);
		friends.setFollow("No");
		friends.setStatus("New");
		friendsdao.savefriends(friends);
		friends.setErrorMessage("Friend request posted successfully.....");
		return new ResponseEntity<friends>(HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updatefriends",method=RequestMethod.PUT)
	public ResponseEntity<friends> updateuser(@RequestBody friends friends)
	{
		//System.out.println("Update user :" + id);
		
		System.out.println("Update user name :" + friends.getFid());
		friendsdao.updatefriends(friends);
		return new ResponseEntity<friends>(friends,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletefriend/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<friends> deleteuser(@PathVariable("id") String id)
	{
		
		//friendsdao.deletefriends(id,uid);
		
		return new ResponseEntity<friends>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/acceptfriend/{id}", method=RequestMethod.GET)
	public ResponseEntity<friends> acceptfriend(@PathVariable("id") String id,HttpSession session)
	{
		register loggedInUser=(register) session.getAttribute("loggedInUser");
		frd.setUserid(loggedInUser.getUser_id());
		frd.setFid(id);
		//frd.setRequestfrom(requestfrom);
		//frd.setRequesteddate(requesteddate);
		frd.setStatus("Accepted");
		return new ResponseEntity<friends>(HttpStatus.OK);
		
	}
	
	
	
	/*@RequestMapping(value="/getfriendbyid/{friendID}", method=RequestMethod.GET)
	public ResponseEntity<friends> getfriendbyid(@PathVariable("friendID") String friendID)
	{
		System.out.println(" And FreindID " +friendID);
		String f=friendID + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And FreindID " +f);
		friends lsts =friendsdao.getfriendbyid(f);
		//System.out.println("GEt friend by id "+lsts.getUserid());
		if(lsts==null)
		{
			return new ResponseEntity<friends>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<friends>(lsts,HttpStatus.OK);
	}*/

}
