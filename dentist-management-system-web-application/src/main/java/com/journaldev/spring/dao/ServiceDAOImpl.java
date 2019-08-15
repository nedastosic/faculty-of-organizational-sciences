package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Service;

@Repository
public class ServiceDAOImpl implements ServiceDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> listServices() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Service> servicesList = session.createQuery("from Service").list();
		for(Service s : servicesList){
			logger.info("Service List::"+s);
		}
		return servicesList;
	}


}
