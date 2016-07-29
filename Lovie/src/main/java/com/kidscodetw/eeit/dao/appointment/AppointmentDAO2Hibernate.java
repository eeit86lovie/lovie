package com.kidscodetw.eeit.dao.appointment;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;

public class AppointmentDAO2Hibernate implements AppointmentDAO2 {

	private static final String SELECT_ALL = "from AppointmentBean2";
	private static final String SELECT_BY_MEMBER = "from AppointmentBean2 where memberId=:memberId";
	private static final String SELECT_BY_SHOWTIME = "from AppointmentBean2 where showtimeId=:showtimeId";
	private SessionFactory sessionFactory;
	
	public AppointmentDAO2Hibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<AppointmentBean2> select() {
		List<AppointmentBean2> result = null;
		try {
			result = getSession().createQuery(SELECT_ALL).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public AppointmentBean2 select(Integer id) {
		return (AppointmentBean2) getSession().get(AppointmentBean2.class, id);
	}

	@Override
	public List<AppointmentBean2> selectByMemberId(Integer memberId) {
		Query query = getSession().createQuery(SELECT_BY_MEMBER);
		query.setParameter("memberId", memberId);
		return query.list();
	}

	@Override
	public List<AppointmentBean2> selectByShowtimeId(Integer showtimeId) {
		Query query = getSession().createQuery(SELECT_BY_SHOWTIME);
		query.setParameter("showtimeId", showtimeId);
		return query.list();
	}

	@Override
	public boolean delete(Integer id) {
		AppointmentBean2 bean = (AppointmentBean2) this.getSession().get(AppointmentBean2.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public AppointmentBean2 insert(AppointmentBean2 bean) {
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public AppointmentBean2 update(AppointmentBean2 bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (AppointmentBean2) this.getSession().get(AppointmentBean2.class, bean.getId());
	}

	@Override
	public List<AppointmentsBean> selectcal(Integer memberId,Date showstart,Date showend) {
		String[] color = {"#686868","green","red","#600030","#00CACA"};
		List<AppointmentsBean> result = null;
		try { 
			String SELECT_CAL =
					"select id ,s3 title,s4 color,"+
					"concat('<img src=\"photo/member/',mId,"+
					"'\" style=\"width:30px;float:left;\" /> ',"+
					"showtimeTime,' ',movieName,' <br>',theaterName) tooltip,"+
					"concat(showtimeDate,' ',replace(showtimeTime,'：',':')) start,"+
					"concat('member/profile/',mId) url,"+
					"mId,showtimeId from ("+
					"	select 1 s1,0 s2,'取消' s3,'"+color[0]+"' s4,A.id,acceptedMemberId mId,showtimeId,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	from eeit86.Appointment A join eeit86.Showtime B on A.showtimeId = B.id	"+
					"	where memberId = "+memberId+" and  status=0 	"+
					"	  and showtimeDate between '"+new java.sql.Date(showstart.getTime())+"'"+
					"         and '"+new java.sql.Date(showend.getTime())+"'"+
					"	union 	"+
					"	select 1 s1,1 s2,'邀請進行中' s3,'"+color[1]+"' s4,A.id,acceptedMemberId mId,showtimeId,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	from eeit86.Appointment A join eeit86.Showtime B on A.showtimeId = B.id	"+
					"	where memberId = "+memberId+" and  status=1 	"+
					"	  and showtimeDate between '"+new java.sql.Date(showstart.getTime())+"'"+
					"         and '"+new java.sql.Date(showend.getTime())+"'"+
					"	union 	"+
					"	select 1 s1,2 s2,'邀請約會成功' s3,'"+color[2]+"' s4,A.id,acceptedMemberId mId,showtimeId,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	from eeit86.Appointment A join eeit86.Showtime B on A.showtimeId = B.id	"+
					"	where memberId = "+memberId+" and  status=2 	"+
					"	  and showtimeDate between '"+new java.sql.Date(showstart.getTime())+"'"+
					"         and '"+new java.sql.Date(showend.getTime())+"'"+
					"	union 	"+
					"	select 2 s1,2 s2,'申請約會成功' s3,'"+color[3]+"' s4,A.id,memberId mId,showtimeId,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	from eeit86.Appointment A join eeit86.Showtime B on A.showtimeId = B.id	"+
					"	where acceptedMemberId = "+memberId+" and  status=2 	"+
					"	  and showtimeDate between '"+new java.sql.Date(showstart.getTime())+"'"+
					"         and '"+new java.sql.Date(showend.getTime())+"'"+
					"	union   	"+
					"	select 3 s1,0 s2,'申請中' s3,'"+color[4]+"' s4,B.id,B.mId mId,B.showtimeId,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	from ((select appointmentID	"+
					"	      from eeit86.AppointmentRequest	"+
					"	      where requestMemberId="+memberId+" and status=0) A	"+
					"	     join	"+
					"	 (select id,memberId mId,showtimeId	"+
					"	  from eeit86.Appointment	"+
					"	  where status = 1) B	"+
					"	 on A.appointmentID = B.id )	"+
					"	 join	"+
					"	 (select id,showtimeDate,showtimeTime,movieName,theaterName	"+
					"	  from eeit86.Showtime	"+
					"	  where showtimeDate between '"+new java.sql.Date(showstart.getTime())+"'"+
					"         and '"+new java.sql.Date(showend.getTime())+"' ) D 	"+
					"	 on showtimeId = D.id	) x";	
			System.out.println(SELECT_CAL);
			SQLQuery query = getSession().createSQLQuery(SELECT_CAL);
			query.addEntity(AppointmentsBean.class);
			result = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

}
