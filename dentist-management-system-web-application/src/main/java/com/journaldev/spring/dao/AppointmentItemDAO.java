package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.AppointmentItem;

public interface AppointmentItemDAO {

	public void addAppointmentItem(AppointmentItem p);
	public void updateAppointmentItem(AppointmentItem p);
	public List<AppointmentItem> listAppointmentItems(int id);
	public AppointmentItem getAppointmentItemById(int id);
	public void removeAppointmentItem(int id);
}
