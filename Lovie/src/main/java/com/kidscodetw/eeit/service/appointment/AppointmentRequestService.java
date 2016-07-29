package com.kidscodetw.eeit.service.appointment;

import java.util.List;

import com.kidscodetw.eeit.dao.appointment.AppointmentDAO2;
import com.kidscodetw.eeit.dao.appointment.AppointmentRequestDAO;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;

public class AppointmentRequestService {
	
	private AppointmentRequestDAO appointmentRequestDAO;
	public AppointmentRequestService(AppointmentRequestDAO appointmentRequestDAO){
		this.appointmentRequestDAO = appointmentRequestDAO;
	}
	
	public Integer updatestatus(Integer appointmentID, Integer status){
		return appointmentRequestDAO.updatestatus(appointmentID, status);
	}
}
