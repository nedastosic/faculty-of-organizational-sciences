package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Patient;
import org.hibernate.Query;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPatient(Patient p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePatient(Patient p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listPatients() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Patient> patientsList = session.createQuery("from Patient").list();
		for(Patient p : patientsList){
			logger.info("Person List::"+p);
		}
		return patientsList;
	}
        
        @SuppressWarnings("unchecked")
	@Override
	public List<Patient> listPatients(String search) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q= session.createQuery("from Patient where name LIKE :search");
                q.setParameter("search", "%"+search+"%");
                List<Patient> patientsList =q.list();
		for(Patient p : patientsList){
			logger.info("Person List::"+p);
		}
		return patientsList;
	}

	@Override
	public Patient getPatientById(String id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Patient p = (Patient) session.load(Patient.class, new String(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePatient(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		Patient p = (Patient) session.load(Patient.class, new String(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
