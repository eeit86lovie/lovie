package com.kidscodetw.eeit.service.appoint;

import java.util.List;

import com.kidscodetw.eeit.dao.appoint.AppointmentDAO;
import com.kidscodetw.eeit.entity.appoint.AppointmentBean;

public class AppointmentService {
	
	private AppointmentDAO appointmentDAO;
	public AppointmentService(AppointmentDAO appointmentDAOHibernate){
		this.appointmentDAO = appointmentDAOHibernate;
	}
	
	public List<AppointmentBean> select(){
		List<AppointmentBean> result = null;
		result = appointmentDAO.select();
		return result;
	}

	public AppointmentBean select(Integer id){
		AppointmentBean result = null;
		if(id!=0){
			result = appointmentDAO.select(id);
		}
		return result;
	}

	public List<AppointmentBean> selectByMemberId(Integer memberId){
		List<AppointmentBean> result = null;
		if(memberId!=0){
			result = appointmentDAO.selectByMemberId(memberId);
		}
		return result;
	}
	
	public List<AppointmentBean> selectByShowtimeId(Integer showtimeId){
		List<AppointmentBean> result = null;
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

	public AppointmentBean update(AppointmentBean bean){
		AppointmentBean result = null;
		if(bean!=null && bean.getMemberId()!=0 && bean.getShowtimeId()!=0){
			result = appointmentDAO.update(bean);
		}
		return result;
	}
	
	public boolean delete(Integer id){
		boolean result = false;
		if(id!=0){
			result = appointmentDAO.delete(id);
		}
		return result;
	}

}
