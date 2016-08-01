package com.kidscodetw.eeit.service.appointment;

import java.sql.Date;
import java.util.List;

import com.kidscodetw.eeit.dao.appointment.AppointmentDAO2;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
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

	public AppointmentBean2 insert(AppointmentBean2 bean){
		AppointmentBean2 result = null;
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
}
