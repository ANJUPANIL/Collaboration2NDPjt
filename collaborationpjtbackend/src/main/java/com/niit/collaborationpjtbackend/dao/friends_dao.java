package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.friends;



public interface friends_dao {

	public void savefriends(friends friends);
	
	public List<friends> showallfriends(String userid);
	
	public List<friends> shownewfriendrequests(String userid);
	
	public friends getfriendbyid(String id);
	
	public void updatefriends(friends friends);
	
	public void deletefriends(String friendid,String userid);
	
	public void acceptfriendrequest(String id);
	
	public void deletefriendrequest(String id);
	
	public void unfriend(String id);
	
	public void unfollow(String id);
	
	
	
}
