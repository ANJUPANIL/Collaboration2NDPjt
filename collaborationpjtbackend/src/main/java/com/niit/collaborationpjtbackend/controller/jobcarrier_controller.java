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

import com.niit.collaborationpjtbackend.dao.jobcarrier_dao;
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
		return new ResponseEntity<List<jobcarrier>>(jobs,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/savejob/", method=RequestMethod.POST)
	public ResponseEntity<jobcarrier> createuser(@RequestBody jobcarrier job)
	{
		
			jobdao.savejob(job);
			job.setErrorMessage("job posted successfully.....");
			return new ResponseEntity<jobcarrier>(job,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/updatejob",method=RequestMethod.PUT)
	public ResponseEntity<jobcarrier> updateuser(@RequestBody jobcarrier job)
	{
		//System.out.println("Update user :" + id);
		
		System.out.println("Update user name :" + job.getJob_companyname());
		jobdao.updatejob(job);
		return new ResponseEntity<jobcarrier>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deletejob/{id}", method=RequestMethod.DELETE)
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

}
