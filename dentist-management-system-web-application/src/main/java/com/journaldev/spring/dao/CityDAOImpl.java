package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.City;

@Repository
public class CityDAOImpl implements CityDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCities() {
		Session session = this.sessionFactory.getCurrentSession();
		List<City> citiesList = session.createQuery("from City").list();
		for(City p : citiesList){
			logger.info("City List::"+p);
		}
		return citiesList;
	}


}
