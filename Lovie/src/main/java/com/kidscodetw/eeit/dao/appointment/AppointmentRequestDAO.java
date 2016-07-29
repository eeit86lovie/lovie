package com.kidscodetw.eeit.dao.appointment;

import com.kidscodetw.eeit.entity.appointment.AppointmentRequestBean;

public interface AppointmentRequestDAO {

	//public abstract List<AppointmentRequestBean> select(Integer appointmentID);
	public abstract Integer updatestatus(Integer appointmentID,Integer status);
}