package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Dentist;
import org.hibernate.Query;

@Repository
public class DentistDAOImpl implements DentistDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DentistDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	@Override
	public Dentist validateUser(Dentist login) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Dentist where username=:u and password=:p");
                q.setParameter("u", login.getUsername());
                q.setParameter("p", login.getPassword());
                List<Dentist> list=q.list();
		if (list.isEmpty())
                    return null;
                else 
                    return list.get(0);
	}

}
