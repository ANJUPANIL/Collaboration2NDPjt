package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.forummaster;

@Repository
@Transactional
public class forummaster_daoimpl implements forummaster_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveforum(forummaster forum) {
		sessionFactory.getCurrentSession().save(forum);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<forummaster> showallforum() {
		
		return (List<forummaster>)sessionFactory.getCurrentSession().createQuery("from forummaster").list();
	}

	@Override
	public forummaster getforumbyid(String id) {
		
		return (forummaster) sessionFactory.getCurrentSession().get(forummaster.class, new String(id));
	}

	@Override
	public void updateforum(forummaster forum) {
		sessionFactory.getCurrentSession().update(forum);
		
	}

	@Override
	public void deleteforum(String id) {
		sessionFactory.getCurrentSession().createQuery("update forummaster set status='decative' where forum_id = '"+id+"'").executeUpdate();
		
	}

	@Override
	public void forumlikes(String id) {
		sessionFactory.getCurrentSession().createQuery("update forummaster set forum_likes=forum_likes+1 where forum_id = '"+id+"'").executeUpdate();
		
	}

	@Override
	public void forumdislikes(String id) {
		sessionFactory.getCurrentSession().createQuery("update forummaster set forum_dislikes=forum_dislikes+1 where forum_id = '"+id+"'").executeUpdate();
		
	}

}
