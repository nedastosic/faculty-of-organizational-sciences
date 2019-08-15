package com.journaldev.spring.service;

import com.journaldev.spring.model.Appointment;
import java.util.List;



public interface AppointmentService {

	public void addAppointment(Appointment p);
	public void updateAppointment(Appointment p);
	public List<Appointment> listAppointments();
	public Appointment getAppointmentById(int id);
	public void removeAppointment(int id);
	
}
