package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbeditBean;

public interface AppointmentRequestDAO {
	public abstract List<AppointmentbBean> selectByMid(Integer requestMemberId);
	public abstract Integer updatestatusByAid(Integer appointmentID,Integer status);
	public abstract Integer updatestatusByAidMid(Integer appointmentID,Integer requestMemberId, Integer status);
	public abstract Integer updatecontentByAidMid(Integer appointmentID,Integer requestMemberId, String content);
	public abstract AppointmentbeditBean selectByAidMid(Integer appointmentID,Integer requestMemberId);
	public abstract Integer selectBySidMid(Integer showtimeID, Integer requestMemberId);
}