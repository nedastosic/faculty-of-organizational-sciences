package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Patient;

public interface PatientDAO {

	public void addPatient(Patient p);
	public void updatePatient(Patient p);
	public List<Patient> listPatients();
	public List<Patient> listPatients(String search);
	public Patient getPatientById(String id);
	public void removePatient(String id);
}
