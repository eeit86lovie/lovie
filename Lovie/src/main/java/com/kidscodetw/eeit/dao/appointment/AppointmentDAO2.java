package com.kidscodetw.eeit.dao.appointment;

import java.sql.Date;
import java.util.List;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentaBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;

public interface AppointmentDAO2 {

	public abstract List<AppointmentBean2> select();
	public abstract AppointmentBean2 select(Integer id);
	public abstract List<AppointmentBean2> selectByShowtimeId(Integer showtimeId);
	public abstract List<AppointmentBean2> selectByMemberId(Integer memberId);
	public abstract AppointmentBean2 insert(AppointmentBean2 bean);
	public abstract Integer updatestatusByAid(Integer appointmentID, Integer status);
	public abstract Integer updateacceptedByAid(Integer appointmentID,String content, Integer acceptedMemberId);
	public abstract Integer updatestatusto0ByAid(Integer appointmentID);
	public abstract AppointmentBean2 update(AppointmentBean2 bean);
	public abstract boolean delete(Integer id);
	public abstract List<AppointmentsBean> selectcal(Integer memberId,Date showstart,Date showend);
	public abstract List<AppointmentaBean> selectByMid(Integer memberId);
	public abstract AppointmentaeditBean selectByAidMid(Integer appointmentID,Integer memberId); 

}