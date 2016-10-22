package com.niit.collaborationpjtbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class index_controller {
	
	@RequestMapping()
	public String getindex()
	{
		System.out.println("inside index controller");
		return "index";
	}
	
	
	@RequestMapping(value="/register")
	public String getregister()
	{
		System.out.println("inside register  controller");
		return "register";
	}
	
	

}
