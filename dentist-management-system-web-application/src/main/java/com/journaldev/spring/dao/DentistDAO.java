package com.journaldev.spring.dao;

import com.journaldev.spring.model.Dentist;
import java.util.List;

import com.journaldev.spring.model.Patient;

public interface DentistDAO {
	public Dentist validateUser(Dentist login);
}
