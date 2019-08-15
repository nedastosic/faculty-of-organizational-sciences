package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.AppointmentItem;

@Repository
public class AppointmentItemDAOImpl implements AppointmentItemDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentItemDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addAppointmentItem(AppointmentItem p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateAppointmentItem(AppointmentItem p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppointmentItem> listAppointmentItems(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<AppointmentItem> AppointmentItemsList = session.createQuery("from AppointmentItem where appointment="+id).list();
		for(AppointmentItem p : AppointmentItemsList){
			logger.info("Person List::"+p);
		}
		return AppointmentItemsList;
	}

	@Override
	public AppointmentItem getAppointmentItemById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		AppointmentItem p = (AppointmentItem) session.load(AppointmentItem.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeAppointmentItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AppointmentItem p = (AppointmentItem) session.load(AppointmentItem.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
