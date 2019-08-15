package com.journaldev.spring.service;

import com.journaldev.spring.model.AppointmentItem;
import java.util.List;



public interface AppointmentItemService {

	public void addAppointmentItem(AppointmentItem p);
	public void updateAppointmentItem(AppointmentItem p);
	public List<AppointmentItem> listAppointmentItems(int id);
	public AppointmentItem getAppointmentItemById(int id);
	public void removeAppointmentItem(int id);
	
}
