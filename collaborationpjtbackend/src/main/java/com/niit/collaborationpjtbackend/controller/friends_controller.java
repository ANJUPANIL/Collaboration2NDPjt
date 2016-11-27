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
import com.niit.collaborationpjtbackend.dao.register_dao;
import com.niit.collaborationpjtbackend.model.friends;
import com.niit.collaborationpjtbackend.model.jobbookmark;
import com.niit.collaborationpjtbackend.model.register;



@RestController
public class friends_controller {
	
	@Autowired
	friends_dao friendsdao;
	
	friends frd;
	
	@Autowired
	register_dao regdao;
	
	
	@RequestMapping(value="/allfriends", method=RequestMethod.GET)
	public ResponseEntity<List<friends>> listallusers(HttpSession session)
	{
		register loggedInUser=(register) session.getAttribute("loggedInUser");
		System.out.println("loggedInUser "+loggedInUser.getUser_id());
		List<friends> friends =friendsdao.showallfriends(loggedInUser.getUser_id());
		if(friends.size()==0)
		{
			return new ResponseEntity<List<friends>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<friends>>(friends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/savefriends/{friendID}", method=RequestMethod.POST)
	public ResponseEntity<friends> createuser(@PathVariable("friendID") String friendID,HttpSession session)
	{	
		System.out.println("Freind save controller");
		System.out.println(" And FreindID " +friendID);
		String f=friendID + ".com";   //Bcoz .com is not acceptable
		System.out.println(" And FreindID " +f);
		friends friends=new friends();
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");
				
		int flag=0;
		List<friends> t=friendsdao.showallfriends(loggedInUserId);
		for(int i=0;i<t.size();i++)
		{
			if(t.get(i).getRequestto().equals(f) && t.get(i).getUserid().equals(loggedInUserId))
			{
				flag=1;
			}
		}
		if(flag==1)
		{
			friends.setErrorMessage("Already add friend....");
		}
		else{
			
		
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
		friends.setErrorMessage("Friend request send successfully.....");
		}
		return new ResponseEntity<friends>(friends,HttpStatus.OK);
		
		
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
	
	@RequestMapping(value="/acceptfriend/{id}", method=RequestMethod.PUT)
	public ResponseEntity<friends> acceptfriend(@PathVariable("id") String id)
	{
		
		System.out.println("Friend request id  "+ id);
		friendsdao.acceptfriendrequest(id);
		return new ResponseEntity<friends>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/rejectfriend/{id}", method=RequestMethod.PUT)
	public ResponseEntity<friends> rejectfriend(@PathVariable("id") String id)
	{
		
		System.out.println("Friend request id  "+ id);
		friendsdao.deletefriendrequest(id);
		return new ResponseEntity<friends>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getmyfriendrequest", method=RequestMethod.GET)
	public ResponseEntity<List<friends>> listallfriendrequest(HttpSession session)
	{
		register loggedInUser=(register) session.getAttribute("loggedInUser");
		System.out.println("loggedInUser "+loggedInUser.getUser_id());
		List<friends> friends =friendsdao.shownewfriendrequests(loggedInUser.getUser_id());
		if(friends.size()==0)
		{
			return new ResponseEntity<List<friends>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<friends>>(friends,HttpStatus.OK);
		
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

	
	@RequestMapping(value="/friendprofile/{friendID}", method=RequestMethod.GET)
	public ResponseEntity<register> getuser(@PathVariable("friendID") String friendID)
	{
		System.out.println(" And FreindID " +friendID);
		String f=friendID + ".com";   //Bcoz .com is not acceptable
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
}
