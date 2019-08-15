package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.AppointmentItem;
import com.journaldev.spring.dao.AppointmentItemDAO;

@Service
public class AppointmentItemServiceImpl implements AppointmentItemService {
	
	private AppointmentItemDAO appointmentItemDAO;

	public void setAppointmentItemDAO(AppointmentItemDAO appointmentItemDAO) {
		this.appointmentItemDAO = appointmentItemDAO;
	}

	@Override
	@Transactional
	public void addAppointmentItem(AppointmentItem p) {
		this.appointmentItemDAO.addAppointmentItem(p);
	}

	@Override
	@Transactional
	public void updateAppointmentItem(AppointmentItem p) {
		this.appointmentItemDAO.updateAppointmentItem(p);
	}

	@Override
	@Transactional
	public List<AppointmentItem> listAppointmentItems(int id) {
		return this.appointmentItemDAO.listAppointmentItems(id);
	}

	@Override
	@Transactional
	public AppointmentItem getAppointmentItemById(int id) {
		return this.appointmentItemDAO.getAppointmentItemById(id);
	}

	@Override
	@Transactional
	public void removeAppointmentItem(int id) {
		this.appointmentItemDAO.removeAppointmentItem(id);
	}

}
