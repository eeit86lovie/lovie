package com.kidscodetw.eeit.dao.appointment;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentaBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentareditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;

public class AppointmentDAO2Hibernate implements AppointmentDAO2 {

	private static final String SELECT_ALL = "from AppointmentBean2";
	private static final String SELECT_BY_MEMBER = "from AppointmentBean2 where memberId=:memberId";
	private static final String SELECT_BY_SHOWTIME = "from AppointmentBean2 where showtimeId=:showtimeId";
	private static final String UPDATESTATUS_BY_ID = "update AppointmentBean2 set status=:status where id=:appointmentID";
	private static final String UPDATECONTENT_BY_ID_AID = "update AppointmentBean2 set content=:content where id=:appointmentID ";
	private static final String UPDATESTATUSRTO8_BY_ID = "update AppointmentRequestBean set status=8 where appointmentID=:appointmentID and status in (0,1,2) ";
	private static final String UPDATEACCEPTED_BY_ID = "update AppointmentBean2 set content=:content ,acceptedMemberId=:acceptedMemberId ,acceptedTime=CURRENT_TIMESTAMP() ,status=2 where id=:appointmentID";
	private static final String UPDATEACCEPTEDR1_BY_ID = "update AppointmentRequestBean set status=2 where appointmentID=:appointmentID and status in (0,1,2) ";
	private static final String UPDATEACCEPTEDR2_BY_ID = "update AppointmentRequestBean set status=1 where appointmentID=:appointmentID and requestMemberId=:acceptedMemberId and status in (0,1,2) ";

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
	public Integer updatestatusByAid(Integer appointmentID, Integer status) {
		   Query query = getSession().createQuery(UPDATESTATUS_BY_ID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("status", status);
		   int updateCount = query.executeUpdate();
		   return updateCount;
	}

	@Override
	public Integer updateacceptedByAid(Integer appointmentID,String content, Integer acceptedMemberId) {
	    //1.申請狀態為 [1:進行] && 沒有勾取消
		//  (a)都沒有人申請,則只異動內容(-1),
		//  (b)有人申請,
		//    update app  內容,接受對像acceptedMemberId,時間acceptedTime,status=2.成功
	    //    update appr status=2否  where appointmentID= ? and status in (0,1)
	    //    update appr status=1是  where appointmentID= ? and requestMemberId= ? and status = 0
		//UPDATEACCEPTEDR1_BY_ID = "update AppointmentRequestBean set status=2 where appointmentID=:appointmentID and status in (0,1,2) ";
		//UPDATEACCEPTEDR2_BY_ID = "update AppointmentRequestBean set status=1 where appointmentID=:appointmentID and requestMemberId=:acceptedMemberId and status in (0,1,2) ";
		if (acceptedMemberId == -1)
		{
		   Query query = getSession().createQuery(UPDATECONTENT_BY_ID_AID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("content", content);
		   int updateCount1 = query.executeUpdate();
		   return updateCount1;
		}else{
		   Query query = getSession().createQuery(UPDATEACCEPTED_BY_ID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("content", content);
		   query.setParameter("acceptedMemberId", acceptedMemberId);
		   int updateCount = query.executeUpdate();
		   if (updateCount != 1)
			   return -1;
		   else
		   {
			   query = getSession().createQuery(UPDATEACCEPTEDR1_BY_ID);
			   query.setParameter("appointmentID", appointmentID);
			   updateCount = query.executeUpdate();
			   if (updateCount <= 0)
				   return -1;
			   else
			   {
				   query = getSession().createQuery(UPDATEACCEPTEDR2_BY_ID);
				   query.setParameter("appointmentID", appointmentID);
				   query.setParameter("acceptedMemberId", acceptedMemberId);
				   updateCount = query.executeUpdate();
				   return updateCount;
			   }
		   }
		}
	}
	
	@Override
	public Integer updatestatusto0ByAid(Integer appointmentID) {
	    //2.(申請狀態為 [1:進行]或[2.成功]) && 勾取消
	    //    update app 狀態改為 [0.取消]
	    //    update appr status=8取消(邀請者)  where appointmentID= ? and status in (0,1,2)
		//UPDATESTATUS_BY_ID = "update AppointmentBean2 set status=:status where id=:appointmentID";
		//UPDATESTATUSRTO8_BY_ID = "update AppointmentRequestBean set status=8 where appointmentID=:appointmentID and status in (0,1,2) ";
		   Query query = getSession().createQuery(UPDATESTATUS_BY_ID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("status", 0);
		   int updateCount = query.executeUpdate();
		   if (updateCount != 1)
			   return -1;
		   else
		   {
			   query = getSession().createQuery(UPDATESTATUSRTO8_BY_ID);
			   query.setParameter("appointmentID", appointmentID);
			   int updateCount2 = query.executeUpdate();
			   return updateCount;
		   }
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
			//System.out.println(SELECT_CAL);
			SQLQuery query = getSession().createSQLQuery(SELECT_CAL);
			query.addEntity(AppointmentsBean.class);
			result = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<AppointmentaBean> selectByMid(Integer memberId) {
		List<AppointmentaBean> result = null;
		try { 
			String SELECT_ByMid =
		        " select C.id,pubTime,showtimeId,astatus,acontent,requestcnt, " +
				"        acceptedMemberId,acceptedTime,gender,nickname, " +
				"        showtimeDate,concat(showtimeTime,' ',theaterName,'<br/>',movieName) showtimeData " +
				" from ( select id,pubTime,showtimeId, " +
				"               acceptedMemberId,acceptedTime, " +
				"               astatus,acontent,count(appointmentID) requestcnt " +
				"        from " +
				"        (select id,pubTime,showtimeId, " +
				" 			   acceptedMemberId,acceptedTime, " +
				" 	           status astatus,content acontent " +
				" 	    from eeit86.Appointment " +
				"         where memberId="+memberId+" and status <> 9) A " +
				" 	   left outer join " +
				" 	   (select appointmentID,requestMemberId " +
				"         from eeit86.AppointmentRequest " +
				"         where status <> 9 ) B " +
				" 	   on A.id = B.appointmentID " +
				"        group by id,pubTime,showtimeId,astatus,acontent " +
				"      ) C " +
				" 	 join " +
				" 	(select id,showtimeDate,showtimeTime,movieName,theaterName " +
				" 	 from eeit86.Showtime) D " +
				" 	 on C.showtimeId = D.id " +
				" 	 left outer join " +
				"     (select id,gender,nickname from eeit86.Member) E " +
				" 	 on acceptedMemberId = E.id " +
				" order by showtimeDate desc " ;
					
			//System.out.println(SELECT_ByMid);
			SQLQuery query = getSession().createSQLQuery(SELECT_ByMid);
			query.addEntity(AppointmentaBean.class);
			result = query.list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}	

	@Override
	public AppointmentaeditBean selectByAidMid(Integer appointmentID,Integer memberId) {
		AppointmentaeditBean result = null;
		try { 
			String SELECT_EDIT_ByAidMid =
			        "select A.id,memberId mId,pubTime,showtimeId,astatus,acontent, " + 
					"       gender,nickname,birthday,constellation,city,district, " + 
				    "       if(birthday= null,null,Year(current_date())-Year(birthday)) age, " +
				    "       if(gender= 0,'女',if(gender=1,'男',gender)) gendertxt, " +
					"       concat(movieName,'<br/>',theaterName,'<br/>',showtimeDate,' ',showtimeTime) showtimeData  " + 
					"from (select id,memberId,pubTime,showtimeId, " + 
					"	         status astatus,content acontent " + 
					"	  from eeit86.Appointment " + 
					"      where status <> 9 and memberId="+memberId+" and id ="+appointmentID+"  ) A " + 
					"	 join " + 
					"	(select id,showtimeDate,showtimeTime,movieName,theaterName " + 
					"	 from eeit86.Showtime) C " + 
					"	 on A.showtimeId = C.id " + 
					"	 join " + 
					"    (select id,gender,nickname,birthday, " + 
					"	        constellation,city,district  " + 
					"	 from eeit86.Member " + 
					"	 where id="+memberId + 
					"	 ) D " + 
					"	 on memberId = D.id " ;
			SQLQuery query = getSession().createSQLQuery(SELECT_EDIT_ByAidMid);
			query.addEntity(AppointmentaeditBean.class);
			List<AppointmentaeditBean> list = query.list();
			if (list != null)
			{  result = list.get(0);
				String SELECTR_EDIT_ByAid =
						"select appointmentID,requestMemberId,requestAppointmentTime,bstatus,bcontent, " +
						"       gender,nickname,birthday,constellation,city,district, " +
						"       if(birthday= null,null,Year(current_date())-Year(birthday)) age, " +
						"       if(gender= 0,'女',if(gender=1,'男',gender)) gendertxt " +
						"from (select appointmentID,requestMemberId,requestAppointmentTime, " +
						"	         status bstatus,content bcontent " +
						"	  from eeit86.AppointmentRequest " +
						"      where appointmentID ="+appointmentID+"  ) B " +
						"	 join " +
						"     (select id,gender,nickname,birthday, " +
						"	        constellation,city,district  " +
						"	  from eeit86.Member " +
						"	 ) D " +
						"	 on requestMemberId = D.id " ;		
				SQLQuery query2 = getSession().createSQLQuery(SELECTR_EDIT_ByAid);
				query2.addEntity(AppointmentareditBean.class);
				List<AppointmentareditBean> listr = query2.list();
				if (listr != null)
				{  result.setAppointmentareditBeans(listr);		}
			    //System.out.println(result);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}	
}
