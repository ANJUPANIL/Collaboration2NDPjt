package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.jobbookmark;
import com.niit.collaborationpjtbackend.model.jobcarrier;

@Repository
@Transactional
public class jobcarrier_daoimpl implements jobcarrier_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savejob(jobcarrier job) {
		sessionFactory.getCurrentSession().save(job);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<jobcarrier> showalljob() {
		
		return (List<jobcarrier>)sessionFactory.getCurrentSession().createQuery("from jobcarrier where status='Active'").list();
	}

	@Override
	public jobcarrier getjobbyid(String id) {
		
		return (jobcarrier) sessionFactory.getCurrentSession().get(jobcarrier.class, new String(id));
	}

	@Override
	public void updatejob(jobcarrier job) {
		sessionFactory.getCurrentSession().update(job);
		
	}

	@Override
	public void deletejob(String id) {
		sessionFactory.getCurrentSession().createQuery("update jobcarrier set status='decative' where job_id = '"+id+"'").executeUpdate();
		
	}

	@Override
	public void makebookmark(jobbookmark job) {
		sessionFactory.getCurrentSession().save(job);
		
	}

	@SuppressWarnings("unchecked" )
	@Override
	public List<jobbookmark> getallbookmarks() {
		return (List<jobbookmark>)sessionFactory.getCurrentSession().createQuery("from jobbookmark where status='New'").list();
	}

	@SuppressWarnings("unchecked" )
	@Override
	public List<jobbookmark> getbookmarkbyuser(String userid) {
		return (List<jobbookmark>)sessionFactory.getCurrentSession().createQuery("from jobbookmark where user_id='"+userid+"'").list();
	}

	


}
