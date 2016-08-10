package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appoint.AppointmentBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentRequestBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;

public class AppointmentRequestDAOHibernate implements AppointmentRequestDAO {
	private static final String UPDATESTATUS_BY_ID = "update AppointmentRequestBean set status=:status where appointmentID=:appointmentID";
	private static final String UPDATESTATUS_BY_ID_MID = "update AppointmentRequestBean set status=:status where appointmentID=:appointmentID and requestMemberId=:requestMemberId";
	private static final String UPDATECONTENT_BY_ID_MID = "update AppointmentRequestBean set content=:content where appointmentID=:appointmentID and requestMemberId=:requestMemberId";
	private static final String SELECT_BY_AID_RMID = "from AppointmentRequestBean where appointmentID=:appointmentID and requestMemberId=:requestMemberId  ";

	private SessionFactory sessionFactory;

	public AppointmentRequestDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public AppointmentRequestBean insert(AppointmentRequestBean bean) {
		this.getSession().save(bean);
		return bean;
	}
	
	@Override
	public AppointmentRequestBean selectByAidRMid(Integer appointmentID,Integer requestMemberId) {
		Query query = getSession().createQuery(SELECT_BY_AID_RMID);
		query.setParameter("appointmentID", appointmentID);
		query.setParameter("requestMemberId", requestMemberId);
		List<AppointmentRequestBean> list = query.list();
		if (list == null || list.size() <= 0)
		   return null;
		else
		   return list.get(0);
	}
	
	@Override
	public Integer updatestatusByAid(Integer appointmentID, Integer status) {
		   Query query = getSession().createQuery(UPDATESTATUS_BY_ID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("status", status);
		   int updateCount = query.executeUpdate();
		   return updateCount;
	}

	@Override
	public Integer updatestatusByAidMid(Integer appointmentID,Integer requestMemberId, Integer status) {
		   Query query = getSession().createQuery(UPDATESTATUS_BY_ID_MID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("requestMemberId", requestMemberId);
		   query.setParameter("status", status);
		   int updateCount = query.executeUpdate();
		   return updateCount;
	}

	@Override
	public Integer updatecontentByAidMid(Integer appointmentID,Integer requestMemberId, String content) {
		   Query query = getSession().createQuery(UPDATECONTENT_BY_ID_MID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("requestMemberId", requestMemberId);
		   query.setParameter("content", content);
		   int updateCount = query.executeUpdate();
		   return updateCount;
	}
	
	@Override
	public List<AppointmentbBean> selectByMid(Integer requestMemberId) {
		List<AppointmentbBean> result = null;
		try { 
			String SELECT_ByMid =
			"		select B.id,B.pubTime,B.showtimeId,showtimeDate," + 
			"          concat(showtimeTime,' ',theaterName,'<br/>',movieName) showtimeData," +
			"	       B.mId mId,E.gender,E.nickname,A.requestAppointmentTime,A.bstatus" + 
			"	from ((select appointmentID,status bstatus,requestAppointmentTime " + 
			"	       from eeit86.AppointmentRequest" + 
			"	       where requestMemberId="+requestMemberId+" and status <> 9" + 
			"	     ) A join" + 
			"		 (select id,memberId mId,pubTime,showtimeId" + 
			"		  from eeit86.Appointment" + 
			"		  where status <> 9 ) B" + 
			"		 on A.appointmentID = B.id" +  
			"		 ) join" + 
			"		(select id,showtimeDate,showtimeTime,movieName,theaterName" + 
			"		 from eeit86.Showtime) D" + 
			"		 on showtimeId = D.id" + 
			"	    join" + 
			"	    (select id,gender,nickname from eeit86.Member) E" + 
			"		 on mId = E.id" + 
			"	order by showtimeDate desc ";

			//System.out.println(SELECT_ByMid);
			SQLQuery query = getSession().createSQLQuery(SELECT_ByMid);
			query.addEntity(AppointmentbBean.class);
			result = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AppointmentbeditBean selectByAidMid(Integer appointmentID,Integer requestMemberId) {
		AppointmentbeditBean result = null;
		try { 
			String SELECT_ByAidMid =
					"select B.id,B.showtimeId,"+
					"       concat(movieName,'<br/>',theaterName,'<br/>',showtimeDate,' ',showtimeTime) showtimeData,"+
					"       B.mId mId,E.nickname,E.gender,E.birthday,E.constellation,E.city,E.district"+
					"	   ,A.bcontent,A.bstatus,B.acontent,B.astatus "+
					"from ((select appointmentID,content bcontent,status bstatus"+
					"       from eeit86.AppointmentRequest"+
					"       where  status <> 9 and requestMemberId="+requestMemberId+
					"          and appointmentID = "+appointmentID+
					"     ) A join"+
					"	 (select id,memberId mId,pubTime,showtimeId,content acontent,status astatus"+
					"	  from eeit86.Appointment"+
					"	  where status <> 9 and id ="+appointmentID+" ) B"+
					"	 on A.appointmentID = B.id"+
					"	 ) join"+
					"	(select id,showtimeDate,showtimeTime,movieName,theaterName"+
					"	 from eeit86.Showtime) D"+
					"	 on showtimeId = D.id"+
					"    join"+
					"    (select id,nickname,gender ,birthday,constellation,city,district"+
					"	 from eeit86.Member) E"+
					"	 on mId = E.id";

			SQLQuery query = getSession().createSQLQuery(SELECT_ByAidMid);
			query.addEntity(AppointmentbeditBean.class);
			List<AppointmentbeditBean> list = query.list();
			if (list != null && list.size() > 0)
			   result = list.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AppointmentbeditBean selectByAidMidwith9(Integer appointmentID,Integer requestMemberId) {
		AppointmentbeditBean result = null;
		try { 
			String SELECT_ByAidMid =
					"select B.id,B.showtimeId,"+
					"       concat(movieName,'<br/>',theaterName,'<br/>',showtimeDate,' ',showtimeTime) showtimeData,"+
					"       B.mId mId,E.nickname,E.gender,E.birthday,E.constellation,E.city,E.district"+
					"	   ,A.bcontent,A.bstatus,B.acontent,B.astatus "+
					"from ((select appointmentID,content bcontent,status bstatus"+
					"       from eeit86.AppointmentRequest"+
					"       where  requestMemberId="+requestMemberId+
					"          and appointmentID = "+appointmentID+
					"     ) A join"+
					"	 (select id,memberId mId,pubTime,showtimeId,content acontent,status astatus"+
					"	  from eeit86.Appointment"+
					"	  where  id ="+appointmentID+" ) B"+
					"	 on A.appointmentID = B.id"+
					"	 ) join"+
					"	(select id,showtimeDate,showtimeTime,movieName,theaterName"+
					"	 from eeit86.Showtime) D"+
					"	 on showtimeId = D.id"+
					"    join"+
					"    (select id,nickname,gender ,birthday,constellation,city,district"+
					"	 from eeit86.Member) E"+
					"	 on mId = E.id";

			SQLQuery query = getSession().createSQLQuery(SELECT_ByAidMid);
			query.addEntity(AppointmentbeditBean.class);
			List<AppointmentbeditBean> list = query.list();
			if (list != null && list.size() > 0)
			   result = list.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Integer selectBySidMid(Integer showtimeID,Integer requestMemberId) {
		Integer result = null;
		try { 
			String SELECT_BySidMid =
					"SELECT A.id " +
					"FROM eeit86.Appointment A " +
					"join " +
					"eeit86.AppointmentRequest AR " +
					"on A.id = AR.appointmentID " +
					"where A.showtimeId="+showtimeID+" and AR.requestMemberId="+requestMemberId+
					"  and AR.status in (0,1)";					
			SQLQuery query = getSession().createSQLQuery(SELECT_BySidMid);
			query.addEntity(AppointmentbeditBean.class);
			List<Integer> list = query.list();
			if (list != null && list.size() > 0 )
			   result = list.get(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}
}
