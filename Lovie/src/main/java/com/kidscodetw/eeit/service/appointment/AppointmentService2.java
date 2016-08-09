package com.kidscodetw.eeit.service.appointment;

import java.sql.Date;
import java.util.List;

import com.kidscodetw.eeit.dao.appointment.AppointmentDAO2;
import com.kidscodetw.eeit.entity.appoint.AppointmentBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentaBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentamBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;

public class AppointmentService2 {
	
	private AppointmentDAO2 appointmentDAO;
	public AppointmentService2(AppointmentDAO2 appointmentDAO){
		this.appointmentDAO = appointmentDAO;
	}
	
	public List<AppointmentBean2> select(){
		List<AppointmentBean2> result = null;
		result = appointmentDAO.select();
		return result;
	}

	public AppointmentBean2 select(Integer id){
		AppointmentBean2 result = null;
		if(id!=0){
			result = appointmentDAO.select(id);
		}
		return result;
	}

	public Integer selectByMemberShowtimeId(Integer memberId,Integer showtimeId){
		Integer result = null;
		if(memberId != 0 && showtimeId != 0 ){
			result = appointmentDAO.selectByMemberShowtimeId(memberId, showtimeId);
		}
		return result;
	}
	
	public List<AppointmentBean2> selectByMemberId(Integer memberId){
		List<AppointmentBean2> result = null;
		if(memberId!=0){
			result = appointmentDAO.selectByMemberId(memberId);
		}
		return result;
	}
	
	public List<AppointmentBean2> selectByShowtimeId(Integer showtimeId){
		List<AppointmentBean2> result = null;
		if(showtimeId!=0){
			result = appointmentDAO.selectByShowtimeId(showtimeId);
		}
		return result;
	}

	public AppointmentBean insert(AppointmentBean bean){
		AppointmentBean result = null;
		if(bean!=null){
			result = appointmentDAO.insert(bean);
		}
		return result;
	}

	public AppointmentBean2 update(AppointmentBean2 bean){
		AppointmentBean2 result = null;
		if(bean!=null && bean.getMemberBean()!=null && bean.getShowtimeBean()!=null){
			result = appointmentDAO.update(bean);
		}
		return result;
	}
	
	public Integer updatestatusByAid(Integer appointmentID, Integer status) {
		return appointmentDAO.updatestatusByAid(appointmentID, status);
	}	

	public Integer updateacceptedByAid(Integer appointmentID, String content, Integer acceptedMemberId) {
		return appointmentDAO.updateacceptedByAid(appointmentID, content, acceptedMemberId);
	}		

	public Integer updatestatusto0ByAid(Integer appointmentID) {
		return appointmentDAO.updatestatusto0ByAid(appointmentID);
	}		

	public boolean delete(Integer id){
		boolean result = false;
		if(id!=0){
			result = appointmentDAO.delete(id);
		}
		return result;
	}
	
	public List<AppointmentsBean> selectcal(Integer memberId,Date showstart,Date showend) {
		List<AppointmentsBean> result = null;
		if(memberId!=0){
			result = appointmentDAO.selectcal(memberId, showstart, showend);
		}
		return result;	
	}
	
	public List<AppointmentaBean> selectByMid(Integer memberId) {
		return appointmentDAO.selectByMid(memberId);
	}

	public AppointmentaeditBean selectByAidMid(Integer appointmentID,Integer memberId) {
		return appointmentDAO.selectByAidMid(appointmentID, memberId);
	}

	public AppointmentaeditBean selectByAidMidwith9(Integer appointmentID,Integer memberId) {
		return appointmentDAO.selectByAidMidwith9(appointmentID, memberId);
	}

	public List<AppointmentamBean> selectBySids(Integer[] showtimeIds) {
		return appointmentDAO.selectBySids(showtimeIds);
	}

}
