package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.City;
import com.journaldev.spring.dao.CityDAO;

@Service
public class CityServiceImpl implements CityService {
	
	private CityDAO cityDAO;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	@Override
	@Transactional
	public List<City> listCities() {
		return this.cityDAO.listCities();
	}


}
