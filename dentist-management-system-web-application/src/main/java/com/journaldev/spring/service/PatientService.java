package com.journaldev.spring.service;

import com.journaldev.spring.model.Patient;
import java.util.List;



public interface PatientService {

	public void addPatient(Patient p);
	public void updatePatient(Patient p);
	public List<Patient> listPatients();
	public List<Patient> listPatients(String search);
	public Patient getPatientById(String id);
	public void removePatient(String id);
	
}
