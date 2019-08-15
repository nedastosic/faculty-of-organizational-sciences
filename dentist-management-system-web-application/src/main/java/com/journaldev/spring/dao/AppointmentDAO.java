package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Appointment;

public interface AppointmentDAO {

	public void addAppointment(Appointment p);
	public void updateAppointment(Appointment p);
	public List<Appointment> listAppointments();
	public Appointment getAppointmentById(int id);
	public void removeAppointment(int id);
}
