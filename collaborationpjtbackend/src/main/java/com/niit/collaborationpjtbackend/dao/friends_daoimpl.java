package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationpjtbackend.model.friends;



@Repository
public class friends_daoimpl implements friends_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savefriends(friends friends) {
		sessionFactory.getCurrentSession().save(friends);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<friends> showallfriends() {
		
		return (List<friends>)sessionFactory.getCurrentSession().createQuery("from friends where status=true").list();
	}

	@Override
	public friends getfriendsbyid(String id) {
		
		return (friends) sessionFactory.getCurrentSession().get(friends.class, new String(id));
	}

	@Override
	public void updatefriends(friends friends) {
		sessionFactory.getCurrentSession().update(friends);
		
	}

	@Override
	public void deletefriends(String id) {
		sessionFactory.getCurrentSession().createQuery("update friends set status=false where fid = '"+id+"'").executeUpdate();
		
	}

}
