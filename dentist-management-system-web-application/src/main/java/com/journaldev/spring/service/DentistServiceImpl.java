package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Dentist;
import com.journaldev.spring.dao.DentistDAO;

@Service
public class DentistServiceImpl implements DentistService {
	
	private DentistDAO dentistDAO;

	public void setDentistDAO(DentistDAO patientDAO) {
		this.dentistDAO = patientDAO;
	}

	@Override
	@Transactional
        public Dentist validateUser(Dentist login){
            return this.dentistDAO.validateUser(login);
        }
}
