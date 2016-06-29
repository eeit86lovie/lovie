package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.AppointmentBean;

public interface AppointmentDAO {

	public abstract List<AppointmentBean> select();
	
	public abstract AppointmentBean select(Integer id);

	public abstract List<AppointmentBean> selectByShowtimeId(Integer showtimeId);
	
	public abstract List<AppointmentBean> selectByMemberId(Integer memberId);

	public abstract AppointmentBean insert(AppointmentBean bean);

	public abstract AppointmentBean update(AppointmentBean bean);
	
	public abstract boolean delete(Integer id);

}