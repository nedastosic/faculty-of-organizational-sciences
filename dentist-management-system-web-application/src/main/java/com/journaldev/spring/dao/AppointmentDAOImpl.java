package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addAppointment(Appointment p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updateAppointment(Appointment p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAppointments() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Appointment> AppointmentsList = session.createQuery("from Appointment").list();
		for(Appointment p : AppointmentsList){
			logger.info("Person List::"+p);
		}
		return AppointmentsList;
	}

	@Override
	public Appointment getAppointmentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Appointment p = (Appointment) session.load(Appointment.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeAppointment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Appointment p = (Appointment) session.load(Appointment.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
