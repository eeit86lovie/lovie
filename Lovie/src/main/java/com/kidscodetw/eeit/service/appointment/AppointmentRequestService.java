package com.kidscodetw.eeit.service.appointment;

import java.util.List;

import com.kidscodetw.eeit.dao.appointment.AppointmentDAO2;
import com.kidscodetw.eeit.dao.appointment.AppointmentRequestDAO;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbeditBean;

public class AppointmentRequestService {
	
	private AppointmentRequestDAO appointmentRequestDAO;
	public AppointmentRequestService(AppointmentRequestDAO appointmentRequestDAO){
		this.appointmentRequestDAO = appointmentRequestDAO;
	}
	
	public Integer updatestatusByAid(Integer appointmentID, Integer status){
		return appointmentRequestDAO.updatestatusByAid(appointmentID, status);
	}
	
	public Integer updatestatusByAidMid(Integer appointmentID,Integer requestMemberId, Integer status) {
		return appointmentRequestDAO.updatestatusByAidMid(appointmentID, requestMemberId, status);
	}
	
	public Integer updatecontentByAidMid(Integer appointmentID,Integer requestMemberId, String content) {
		return appointmentRequestDAO.updatecontentByAidMid(appointmentID, requestMemberId, content);
	}
	
	public List<AppointmentbBean> selectByMid(Integer requestMemberId) {
		return appointmentRequestDAO.selectByMid(requestMemberId);
	}
	
	public AppointmentbeditBean selectByAidMid(Integer appointmentID,Integer requestMemberId) {
		return appointmentRequestDAO.selectByAidMid(appointmentID,requestMemberId);
	}
	
	public Integer selectBySidMid(Integer showtimeID, Integer requestMemberId) {
		return appointmentRequestDAO.selectBySidMid(showtimeID,requestMemberId);
	}
}
