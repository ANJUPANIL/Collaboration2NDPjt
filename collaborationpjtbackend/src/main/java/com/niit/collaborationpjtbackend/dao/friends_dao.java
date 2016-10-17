package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.friends;



public interface friends_dao {

	public void savefriends(friends friends);
	
	public List<friends> showallfriends();
	
	public friends getfriendsbyid(String id);
	
	public void updatefriends(friends friends);
	
	public void deletefriends(String id);
}
