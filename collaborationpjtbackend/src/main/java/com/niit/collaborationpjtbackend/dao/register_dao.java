package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import com.niit.collaborationpjtbackend.model.register;
import com.niit.collaborationpjtbackend.model.role;

public interface register_dao {
	
	public List<register> alluserdetails();
	
	public void saveuserdetails(register details);
	
	public void updateuserdetails(register details);
	
	public void deleteuserdetails(String id);
	
	public register getuserdetailsbyid(String id);
	
	public boolean isvaliduser(String userid,String password);
	
	public void updatepassword(String userid,String password);
	
	public void saverole(role role);
	
	

}
