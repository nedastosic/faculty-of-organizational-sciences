package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Patient;
import com.journaldev.spring.dao.PatientDAO;

@Service
public class PatientServiceImpl implements PatientService {
	
	private PatientDAO patientDAO;

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	@Transactional
	public void addPatient(Patient p) {
		this.patientDAO.addPatient(p);
	}

	@Override
	@Transactional
	public void updatePatient(Patient p) {
		this.patientDAO.updatePatient(p);
	}

	@Override
	@Transactional
	public List<Patient> listPatients() {
		return this.patientDAO.listPatients();
	}
        
        @Override
	@Transactional
	public List<Patient> listPatients(String search) {
		return this.patientDAO.listPatients(search);
	}

	@Override
	@Transactional
	public Patient getPatientById(String id) {
		return this.patientDAO.getPatientById(id);
	}

	@Override
	@Transactional
	public void removePatient(String id) {
		this.patientDAO.removePatient(id);
	}

}
