package com.niit.collaborationpjtbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationpjtbackend.model.eventmaster;

@Repository
@Transactional
public class eventmaster_daoimpl implements eventmaster_dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveevent(eventmaster event) {
		sessionFactory.getCurrentSession().save(event);
		
	}
	
	@SuppressWarnings("unchecked" )
	@Override
	public List<eventmaster> showallevent() {
		
		return (List<eventmaster>)sessionFactory.getCurrentSession().createQuery("from eventmaster where status='Active'").list();
	}

	@Override
	public eventmaster geteventbyid(String id) {
		
		return (eventmaster) sessionFactory.getCurrentSession().get(eventmaster.class, new String(id));
	}

	@Override
	public void updateevent(eventmaster event) {
		sessionFactory.getCurrentSession().update(event);
		
	}

	@Override
	public void deleteevent(String id) {
		sessionFactory.getCurrentSession().createQuery("update eventmaster set status='Deactive' where event_id = '"+id+"'").executeUpdate();
		
	}

}
