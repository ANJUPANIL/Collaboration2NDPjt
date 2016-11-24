package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.blogmaster;



public interface blogmaster_dao {

	public void saveblog(blogmaster blog);
	
	public List<blogmaster> showallblog();
	
	public List<blogmaster> showallpendinblog();
	
	public blogmaster getblogbyid(String id);
	
	public void updateblog(blogmaster blog);
	
	public void deleteblog(String id);
	
	public void activeblog(String id);
	
	public void adminapprove(String id);
	
	public void adminreject(String id);
	
	public void bloglikes(String id);
	
	public void blogdislikes(String id);
	
	
	
}
