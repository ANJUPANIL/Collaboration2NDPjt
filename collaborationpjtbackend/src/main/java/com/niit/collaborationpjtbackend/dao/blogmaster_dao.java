package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.blogmaster;



public interface blogmaster_dao {

	public void saveblog(blogmaster blog);
	
	public List<blogmaster> showallblog();
	
	public blogmaster getblogbyid(String id);
	
	public void updateblog(blogmaster blog);
	
	public void deleteblog(String id);
	
	public void adminapprove(String id);
}
