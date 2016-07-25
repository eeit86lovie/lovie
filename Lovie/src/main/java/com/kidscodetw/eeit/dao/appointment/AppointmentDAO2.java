package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;

public interface AppointmentDAO2 {

	public abstract List<AppointmentBean2> select();
	
	public abstract AppointmentBean2 select(Integer id);

	public abstract List<AppointmentBean2> selectByShowtimeId(Integer showtimeId);
	
	public abstract List<AppointmentBean2> selectByMemberId(Integer memberId);

	public abstract AppointmentBean2 insert(AppointmentBean2 bean);

	public abstract AppointmentBean2 update(AppointmentBean2 bean);
	
	public abstract boolean delete(Integer id);

}