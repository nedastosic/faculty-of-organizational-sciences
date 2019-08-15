package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Appointment;
import com.journaldev.spring.dao.AppointmentDAO;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	private AppointmentDAO appointmentDAO;

	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	@Transactional
	public void addAppointment(Appointment p) {
		this.appointmentDAO.addAppointment(p);
	}

	@Override
	@Transactional
	public void updateAppointment(Appointment p) {
		this.appointmentDAO.updateAppointment(p);
	}

	@Override
	@Transactional
	public List<Appointment> listAppointments() {
		return this.appointmentDAO.listAppointments();
	}

	@Override
	@Transactional
	public Appointment getAppointmentById(int id) {
		return this.appointmentDAO.getAppointmentById(id);
	}

	@Override
	@Transactional
	public void removeAppointment(int id) {
		this.appointmentDAO.removeAppointment(id);
	}

}
