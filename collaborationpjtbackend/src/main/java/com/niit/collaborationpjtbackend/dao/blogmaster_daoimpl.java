package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.blogmaster;

@Repository
@Transactional
public class blogmaster_daoimpl implements blogmaster_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveblog(blogmaster blog) {
		sessionFactory.getCurrentSession().save(blog);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<blogmaster> showallblog() {
		
		return (List<blogmaster>)sessionFactory.getCurrentSession().createQuery("from blogmaster where status='Approved'").list();
	}

	@Override
	public blogmaster getblogbyid(String id) {
		
		return (blogmaster) sessionFactory.getCurrentSession().get(blogmaster.class, new String(id));
	}

	@Override
	public void updateblog(blogmaster blog) {
		sessionFactory.getCurrentSession().update(blog);
		
	}

	@Override
	public void deleteblog(String id) {
		sessionFactory.getCurrentSession().createQuery("update blogmaster set status='Rejected' where blog_id = '"+id+"'").executeUpdate();
		
	}

	@Override
	public void adminapprove(String id) {
		sessionFactory.getCurrentSession().createQuery("update blogmaster set status='Approved' where blog_id = '"+id+"'").executeUpdate();
		
	}

}
