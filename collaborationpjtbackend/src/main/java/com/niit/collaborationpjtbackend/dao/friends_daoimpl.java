package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.friends;

@Repository
@Transactional
public class friends_daoimpl implements friends_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savefriends(friends friends) {
		sessionFactory.getCurrentSession().save(friends);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<friends> showallfriends(String userid) {
		
		String hql="from friends where userid"+ "'" + userid +"' and status='"+"Accepted'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<friends> list=(List<friends>) query.list();
		
		return list;
		
		//return (List<friends>)sessionFactory.getCurrentSession().createQuery("from friends where status='active'").list();
	}

	@Override
	public friends getfriendbyid(String id) {
		
		return (friends) sessionFactory.getCurrentSession().get(friends.class, new String(id));
	}

	@Override
	public void updatefriends(friends friends) {
		sessionFactory.getCurrentSession().update(friends);
		
	}

	@Override
	public void deletefriends(String freindid,String userid) {
		friends f=new friends();
		
		sessionFactory.getCurrentSession().createQuery("update friends set status=false where fid = '"+freindid+"'").executeUpdate();
		
	}

	@SuppressWarnings("unchecked" )
	@Override
	public List<friends> shownewfriendrequests(String userid) {
		
		String hql="from friends where userid"+ "'" + userid +"' and status ='" +"New'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<friends> list=(List<friends>) query.list();
		
		return list;
	}

	@Override
	public void setOnline(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOffline(String userid) {
		// TODO Auto-generated method stub
		
	}

}
