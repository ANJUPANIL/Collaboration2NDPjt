package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.register;
import com.niit.collaborationpjtbackend.model.userlogin;

@Repository
@Transactional
public class register_daoimpl implements register_dao{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked" )
	@Override
	public List<register> alluserdetails() {
		return (List<register>)sessionFactory.getCurrentSession().createQuery("from userdetails").list();
	}

	@Override
	public void saveuserdetails(register details) {
		sessionFactory.getCurrentSession().save(details);
		
	}

	@Override
	public void updateuserdetails(register details) {
		sessionFactory.getCurrentSession().update(details);
		
	}

	@Override
	public void deleteuserdetails(String id) {
		sessionFactory.getCurrentSession().createQuery("delete from register where user_id = '"+id+"'").executeUpdate();
		
	}

	@Override
	public register getuserdetailsbyid(String id) {
		return (register) sessionFactory.getCurrentSession().get(register.class, new String(id));
	}

	@Override
	public boolean isvaliduser(String userid, String password) {
		register u = (register) sessionFactory.getCurrentSession().get(register.class, new String(userid));
		if(u.getUser_id().equals(userid) && u.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	

	@Override
	public void updatepassword(String userid, String password) {
		sessionFactory.getCurrentSession().createQuery("update register set password='"+password+"' where user_id = '"+userid+"'").executeUpdate();
		
	}

	@Override
	public userlogin getdetailsbyid(String userid) {
		return (userlogin) sessionFactory.getCurrentSession().get(userlogin.class, new String(userid));
	}

	@Override
	public void saveuser(userlogin u) {
		
		
		sessionFactory.getCurrentSession().save(u);
		sessionFactory.getCurrentSession().flush();
		
	}

}
