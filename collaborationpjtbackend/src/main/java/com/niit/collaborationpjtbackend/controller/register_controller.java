package com.niit.collaborationpjtbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.collaborationpjtbackend.dao.register_dao;
import com.niit.collaborationpjtbackend.model.register;
import com.niit.collaborationpjtbackend.model.userlogin;

@Controller
public class register_controller {
	@Autowired
	register_dao reg;
	
	@RequestMapping(value="/register")
	public String saveregister()
	{
		System.out.println("inside register controller");
		register r=new register();
		r.setUser_id("anjupanil@gmail.com");
		r.setFname("Anju");
		r.setMname("P");
		r.setLname("Anil");
		r.setDob("20/6/1990");
		r.setAddress("Plakkat house");
		r.setContact("8140772999");
		r.setPassword("anjupanil");
		r.setRole("Student");
		r.setStatus("registered");
		r.setCreateddate("8/10/2016");
		reg.saveuserdetails(r);
		return "index";
	}
	
	@RequestMapping(value="/approve")
	public String savelogin()
	{
		userlogin u =new userlogin();
		
		u.setUser_id("admin@gmail.com");
		u.setPassword("admin123");
		u.setRole("Admin");
		reg.saveuser(u);
		return "index";

	
	}
	
	

}
