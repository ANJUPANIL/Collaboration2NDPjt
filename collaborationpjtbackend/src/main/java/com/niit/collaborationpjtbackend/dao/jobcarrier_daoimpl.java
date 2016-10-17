package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationpjtbackend.model.jobcarrier;



@Repository
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
		
		return (List<jobcarrier>)sessionFactory.getCurrentSession().createQuery("from jobcarrier where status=true").list();
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
		sessionFactory.getCurrentSession().createQuery("update jobcarrier set status=false where job_id = '"+id+"'").executeUpdate();
		
	}

}
