package com.niit.collaborationpjtbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationpjtbackend.dao.jobcarrier_dao;
import com.niit.collaborationpjtbackend.model.jobbookmark;
import com.niit.collaborationpjtbackend.model.jobcarrier;
import com.niit.collaborationpjtbackend.model.register;

@RestController
public class jobcarrier_controller {
	
	@Autowired
	jobcarrier_dao jobdao;
	
	@RequestMapping(value="/alljobs", method=RequestMethod.GET)
	public ResponseEntity<List<jobcarrier>> listallusers()
	{
		List<jobcarrier> jobs =jobdao.showalljob();
		
		if(jobs.size()==0)
		{
			return new ResponseEntity<List<jobcarrier>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("Jobs size" + jobs.size());
		return new ResponseEntity<List<jobcarrier>>(jobs,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/savejob/", method=RequestMethod.POST)
	public ResponseEntity<jobcarrier> createuser(@RequestBody jobcarrier job)
	{
			job.setStatus("Active");
			jobdao.savejob(job);
			job.setErrorMessage("job posted successfully.....");
			return new ResponseEntity<jobcarrier>(job,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updatejob",method=RequestMethod.PUT)
	public ResponseEntity<jobcarrier> updateuser(@RequestBody jobcarrier job)
	{
		//System.out.println("Update user :" + id);
		
		System.out.println("Update user name :" + job.getJob_companyname());
		job.setStatus("Active");
		jobdao.updatejob(job);
		return new ResponseEntity<jobcarrier>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletejob/{id}", method=RequestMethod.PUT)
	public ResponseEntity<jobcarrier> deleteuser(@PathVariable("id") String id)
	{
		
		jobdao.deletejob(id);
		
		return new ResponseEntity<jobcarrier>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/showjobbyid/{id}", method=RequestMethod.GET)
	public ResponseEntity<jobcarrier> getuser(@PathVariable("id") String id)
	{
		
		jobcarrier job =jobdao.getjobbyid(id);
		 
		return new ResponseEntity<jobcarrier>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/makebookmark/{id}", method=RequestMethod.POST)
	public ResponseEntity<jobbookmark> makebookmark(@PathVariable("id") String id,HttpSession session)
	{
			int flag=0;
			jobbookmark job=new jobbookmark();
			String loggedInUserId=(String)session.getAttribute("loggedInUserId");
			
			
			List<jobbookmark> t=jobdao.getbookmarkbyuser(loggedInUserId);
			for(int i=0;i<t.size();i++)
			{
				if(t.get(i).getJob_id().equals(id) && t.get(i).getUser_id().equals(loggedInUserId))
				{
					flag=1;
				}
			}
			if(flag==1)
			{
				job.setErrorMessage("Already applied job.....");
				
			}
			else{
				job.setJob_id(id);
				job.setUser_id(loggedInUserId);
				job.setStatus("New");
				jobdao.makebookmark(job);
				job.setErrorMessage("Applied job successfully.....");
			}
			
			return new ResponseEntity<jobbookmark>(job,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/allbookmark", method=RequestMethod.GET)
	public ResponseEntity<List<jobbookmark>> listallbookmark(HttpSession session)
	{
		String loggedInUserId=(String)session.getAttribute("loggedInUserId");

		List<jobbookmark> jobs =jobdao.getbookmarkbyuser(loggedInUserId);
		
		if(jobs.size()==0)
		{
			return new ResponseEntity<List<jobbookmark>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("Jobs bookmark size" + jobs.size());
		return new ResponseEntity<List<jobbookmark>>(jobs,HttpStatus.OK);
		
	}
}
