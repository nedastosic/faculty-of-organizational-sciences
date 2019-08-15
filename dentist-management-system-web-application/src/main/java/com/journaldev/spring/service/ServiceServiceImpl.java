package com.journaldev.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ServiceDAO;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
	
	private ServiceDAO serviceDAO;

	public void setServiceDAO(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	@Override
	@Transactional
	public List<com.journaldev.spring.model.Service> listServices() {
		return this.serviceDAO.listServices();
	}


}
