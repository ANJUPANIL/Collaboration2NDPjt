package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.forummaster;



public interface forummaster_dao {

	public void saveforum(forummaster forum);
	
	public List<forummaster> showallforum();
	
	public forummaster getforumbyid(String id);
	
	public void updateforum(forummaster forum);
	
	public void deleteforum(String id);
}
