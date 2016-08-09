package com.kidscodetw.eeit.controller.appointment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.entity.appoint.AppointmentBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentaBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;
import com.kidscodetw.eeit.entity.appointment.AppointmovieBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;
import com.kidscodetw.eeit.service.appointment.AppointmentRequestService;
import com.kidscodetw.eeit.service.appointment.AppointmentService2;
import com.kidscodetw.eeit.service.appointment.AppointmovieService;

@Controller
public class AppointmentsMVC {
	//A.0.取消 1:進行 2.成功 9.封存',
	//B.狀態(0尚未回應 ,1是 ,2否 ,7取消(申請者) ,8取消(邀請者), 9取消(管理員))

	@Autowired
	AppointmentService2 appointmentService2;
	@Autowired
	AppointmentRequestService appointmentRequestService;
	@Autowired
	AppointmovieService appointmovieService;
	
	//邀請約會
	@RequestMapping("new_appointmenta")
	public String new_appointmenta(Model model){
		List<GenreBean> genre_names = appointmovieService.select_genre_list();
		List<String> movie_names = appointmovieService.select_movienames_list();
		List<String> theater_names = appointmovieService.select_theaternames_list();
		String[] city_names={"基隆市","台北市","新北市","桃園市","新竹市","苗栗縣","台中市","南投縣","雲林縣","彰化縣","嘉義市","台南市","高雄市","屏東縣","宜蘭縣","花蓮縣","台東市","金門縣","澎湖縣"};

		model.addAttribute("citynames", city_names);
		model.addAttribute("theaternames", theater_names);
		model.addAttribute("genrenames", genre_names);
		model.addAttribute("movienames", movie_names);
		return "appointment/new_appointmenta.jsp";
	}	

	@RequestMapping("new_appointmoviea_json")
	public @ResponseBody List<AppointmovieBean> new_appointmoviea_json(
			   @RequestParam(value="city",required=false) String[] citysels,
			   @RequestParam(value="theaterName",required=false) String theatersels,
			   @RequestParam(value="genreId",required=false) String[] genresels,
			   @RequestParam(value="movieName",required=false) String moviesels,
			   @RequestParam(value="showtimeDatebeg",required=false) String showtimeDatebeg,
			   @RequestParam(value="showtimeDateend",required=false) String showtimeDateend,
		   Model model){
		List<AppointmovieBean> appointmovie_list = appointmovieService.select_movieshowtime_list(citysels, theatersels, genresels, moviesels, showtimeDatebeg, showtimeDateend);
		return appointmovie_list;
	}
	
	@RequestMapping(value="/appointmentaadd/{showtimeID}", produces=MediaType.APPLICATION_JSON)
	public String appointmentaadd(@PathVariable("showtimeID")Integer showtimeID, 
			                          Model model,HttpSession session){
		MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
    		Integer memberId = bean.getId();
	    	if (memberId != null && showtimeID != null)
	    	{
	    		Integer appointmentID =  appointmentService2.selectByMemberShowtimeId(memberId, showtimeID);
  		System.out.println("2 showtimeID"+showtimeID+","+memberId+","+appointmentID);
		    	if (appointmentID != null)
		    	{
			    	AppointmentaeditBean editbean = appointmentService2.selectByAidMidwith9(appointmentID, memberId);
			    	if (editbean != null)
			    	{
						model.addAttribute("oneAppointmentedit",editbean);
				    	return "appointment/appointmentaedit.jsp";
			    	}
		    	}else{
		    		System.out.println("4 showtimeID");
		    		appointmentID =  appointmentRequestService.selectBySidMid(showtimeID, memberId);
			    	if (appointmentID != null)
			    	{
				    	AppointmentbeditBean editbean = appointmentRequestService.selectByAidMid(appointmentID, memberId);
				    	if (editbean != null)
				    	{
					    	//DataTransfer.changeBirthdayToAge
							int intValue = Integer.parseInt(editbean.getBirthday().substring(0, 4));
							java.util.Date today = Calendar.getInstance().getTime();
							Integer memberAge = today.getYear() + 1900 - intValue;
					    	//DataTransfer.genderTransfer
							String gender=null;
							if(editbean.getGender()==0)
								gender="女";
							else if(editbean.getGender()==1)
								gender="男";
							//DataTransfer  end 
							model.addAttribute("memberAge",memberAge);
							model.addAttribute("gender",gender);
							model.addAttribute("oneAppointmentR",editbean);
							return "appointment/appointmentbedit.jsp";
				    	}
			    	}else{
			    		ShowtimeBean showtimebean = appointmovieService.select_showtime(showtimeID);
			    		if (showtimebean != null)
	 		    		{  String showtimeData = showtimebean.getMovieName()+"<br/>"+
			    		        showtimebean.getTheaterName()+"<br/>"+showtimebean.getShowtimeDate()+" "+showtimebean.getShowtimeTime();
			    		   model.addAttribute("showtimeData",showtimeData);
	 		    		}
			    		model.addAttribute("showtimeid",showtimeID);
						String gender=bean.getGender().toString();
						if(bean.getGender()==0)
							gender="女";
						else if(bean.getGender()==1)
							gender="男";
						model.addAttribute("gender",gender);
			        	return "appointment/appointmentaadd.jsp";
			    	}
		    	}
	    	}
    	}
    	return "new_appointmenta";
	}

	@RequestMapping("/appointmentaadd/appointmentAAdd")
    public void AppointmentAUpdate(@RequestParam("showtimeid") Integer showtimeid,
    						  @RequestParam("acontent") String acontent,
    		                  HttpServletResponse response,HttpSession session){
	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
	if (bean != null)
	{
		Integer memberId = bean.getId();
	if (memberId != null && showtimeid != null && acontent.length() > 0 )
	{
		try {
			AppointmentBean appointmentBean = new AppointmentBean();
			appointmentBean.setMemberId(memberId);
			appointmentBean.setShowtimeId(showtimeid);
			appointmentBean.setContent(acontent);
			appointmentBean.setType(1);
			appointmentBean.setStatus(1);
			AppointmentBean res1 = appointmentService2.insert(appointmentBean);
			PrintWriter out;
			try {
				out = response.getWriter();
			    if (res1 == null)
			    	out.println(-1);
			    else
				    out.println(res1.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		}
	}		
	return ;		
    }
	
	//申請約會
	@RequestMapping("new_appointmentb")	
	public String new_appointmentb(Model model){
		List<GenreBean> genre_names = appointmovieService.select_genre_list();
		List<String> movie_names = appointmovieService.select_movienames_list();
		List<String> theater_names = appointmovieService.select_theaternames_list();
		String[] city_names={"基隆市","台北市","新北市","桃園市","新竹市","苗栗縣","台中市","南投縣","雲林縣","彰化縣","嘉義市","台南市","高雄市","屏東縣","宜蘭縣","花蓮縣","台東市","金門縣","澎湖縣"};

		model.addAttribute("citynames", city_names);
		model.addAttribute("theaternames", theater_names);
		model.addAttribute("genrenames", genre_names);
		model.addAttribute("movienames", movie_names);		
		return "appointment/new_appointmentb.jsp";
	}	
		
		
	//查詢(1)
	@RequestMapping("appointments")
	public String getAppointments(){
		return "appointment/appointments.jsp";
	}

	@RequestMapping("/appointmentcaljson")
	public @ResponseBody List<AppointmentsBean> selectjson(
			@RequestParam(value="start",required=false,defaultValue="2000-01-01") Date showstart,
			@RequestParam(value="end",required=false,defaultValue="2100-01-01") Date showend,
			HttpSession session) {
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
    	Integer memberId = bean.getId();
		List<AppointmentsBean> appointment_list = appointmentService2.selectcal(memberId, showstart, showend);
		return appointment_list;
    	}else
    	{
    		return null;
    	}
    }
	
	//查詢(a)
	@RequestMapping("appointmenta")
	public String getAppointmenta(){
		return "appointment/appointmenta.jsp";
	}

	@RequestMapping("/appointmentajson")
	public @ResponseBody List<AppointmentaBean> selectAByMid(HttpSession session) {
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
	    	Integer memberId = bean.getId();
			List<AppointmentaBean> appointment_list = appointmentService2.selectByMid(memberId);
			return appointment_list;
    	}else
    	{   return null;  	}
	}	
	
	@RequestMapping(value="/appointmentaedit/{appointmentID}", produces=MediaType.APPLICATION_JSON)
	public String getAppointmentaedit(@PathVariable("appointmentID")Integer appointmentID, 
			                          Model model,HttpSession session){
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
    		Integer memberId = bean.getId();
	    	if (memberId != null && appointmentID != null)
	    	{
		    	AppointmentaeditBean editbean = appointmentService2.selectByAidMid(appointmentID, memberId);
		    	if (editbean != null)
		    	{
					model.addAttribute("oneAppointmentedit",editbean);
		    	}
	    	}
    	}
    	return "appointment/appointmentaedit.jsp";
	}
	
	@RequestMapping("/appointmentaedit/appointmentAUpdate")
    public void AppointmentAUpdate(@RequestParam("appointmentid") Integer appointmentID,
    						  @RequestParam("acontent") String acontent,
    						  @RequestParam("acancel") Boolean acancel,
    		                  @RequestParam("astatus") Integer astatus,
    		                  @RequestParam("radiomid") Integer radiomid,
    		                  HttpServletResponse response,HttpSession session){
	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
	if (bean != null)
	{
		Integer memberId = bean.getId();
	if (memberId != null && appointmentID != null)
	{
		//說明：1.只有申請狀態為 [1.進行] 才可修改內容<br />
		//    2.只有申請狀態為 [1.進行] 或 [2.成功] 才可進行取消
		try {
			//System.out.println(appointmentID+","+acontent+","+acancel+","+astatus+","+memberId+","+radiomid);
			Boolean finres = true;
		    //1.申請狀態為 [1:進行] && 沒有勾取消
			//  (a)都沒有人申請,則只異動內容(-1),
			//  (b)有人申請,
			//    update app  內容,接受對像acceptedMemberId,時間acceptedTime,status=2.成功
		    //    update appr status=2否  where appointmentID= ? and status in (0,1)
		    //    update appr status=1是  where appointmentID= ? and requestMemberId= ? and status = 0
			if (acancel != true && astatus == 1 )
			{  
			   Integer res1 = appointmentService2.updateacceptedByAid(appointmentID, acontent, radiomid);
			   if (res1 <= 0)
				   finres = false;
			}
			
		    //2.(申請狀態為 [1:進行]或[2.成功]) && 勾取消
		    //    update app 狀態改為 [0.取消]
		    //    update appr status=8取消(邀請者)  where appointmentID= ? and status in (0,1,2)
			if (acancel == true && (astatus == 1 || astatus == 2)) 
			{
			    Integer res2 = appointmentService2.updatestatusto0ByAid(appointmentID);
			    if (res2 <= 0)
				   finres = false;
			} 
			PrintWriter out;
			try {
				out = response.getWriter();
			    out.println(finres);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		}
	}		
	return ;		
    }
	
	//查詢(b)
	@RequestMapping("appointmentb")
	public String getAppointmentb(){
		return "appointment/appointmentb.jsp";
	}


	@RequestMapping("/appointmentbjson")
	public @ResponseBody List<AppointmentbBean> selectBByMid(HttpSession session) {
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
	    	Integer memberId = bean.getId();
			List<AppointmentbBean> appointmentr_list = appointmentRequestService.selectByMid(memberId);
			return appointmentr_list;
    	}else
    	{
    		return null;
    	}
	}
	
	@RequestMapping(value="/appointmentbedit/{appointmentID}", produces=MediaType.APPLICATION_JSON)
	public String getAppointmentbedit(@PathVariable("appointmentID")Integer appointmentID, 
			                          Model model,HttpSession session){
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	if (bean != null)
    	{
    		Integer memberId = bean.getId();
	    	if (memberId != null && appointmentID != null)
	    	{
		    	AppointmentbeditBean editbean = appointmentRequestService.selectByAidMid(appointmentID, memberId);
		    	if (editbean != null)
		    	{
			    	//DataTransfer.changeBirthdayToAge
					int intValue = Integer.parseInt(editbean.getBirthday().substring(0, 4));
					java.util.Date today = Calendar.getInstance().getTime();
					Integer memberAge = today.getYear() + 1900 - intValue;
			    	//DataTransfer.genderTransfer
					String gender=null;
					if(editbean.getGender()==0)
						gender="女";
					else if(editbean.getGender()==1)
						gender="男";
					//DataTransfer  end 
					model.addAttribute("memberAge",memberAge);
					model.addAttribute("gender",gender);
					model.addAttribute("oneAppointmentR",editbean);
		    	}
	    	}
    	}
    	return "appointment/appointmentbedit.jsp";
	}

	@RequestMapping("/appointmentbedit/appointmentRUpdate")
    public void AppointmentRUpdate(@RequestParam("appointmentid") Integer appointmentID,
    						  @RequestParam("bcontent") String bcontent,
    						  @RequestParam("bcancel") Boolean bcancel,
    		                  @RequestParam("bstatus") Integer bstatus,
    		                  HttpServletResponse response,HttpSession session){
	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
	if (bean != null)
	{
		Integer memberId = bean.getId();
	if (memberId != null && appointmentID != null)
	{
	    //申請狀態為 [0.尚未回應]
		//  upate appR.內容
	    //勾取消
	    // (1)申請狀態為 [0.尚未回應]
	    //   appR 狀態改為 [7取消(申請者)]
	    // (2)申請狀態為[1.是]
		//   appR 狀態改為 [7取消(申請者)]
	    //   所有同一個appid 狀態改為 全改為[9取消(管理員)]
	    //   app 狀態改為 [0.取消]
		try {
			//System.out.println(appointmentID+","+bcontent+","+bcancel+","+bstatus+","+memberId);
			Boolean finres = true;
			if (bstatus == 0)
			{
			   Integer res1 = appointmentRequestService.updatecontentByAidMid(appointmentID, memberId, bcontent);
			   if (res1 <= 0)
				   finres = false;
			   else
			   {
				   if (bcancel == true)
				   {
					   Integer res2 = appointmentRequestService.updatestatusByAidMid(appointmentID, memberId, 7);
					   if (res2 <= 0)
						   finres = false;
				   }
			   }
			}
			//   appR 狀態改為 [7取消(申請者)]
		    //   所有同一個appid 狀態改為 全改為[9取消(管理員)]
		    //   app 狀態改為 [0.取消]
			if (bstatus == 1 && bcancel == true)
			{
			   Integer res3 = appointmentService2.updatestatusByAid(appointmentID, 0);
			   if (res3 <= 0)
				   finres = false;
			   else
			   {
				   appointmentRequestService.updatestatusByAid(appointmentID, 9);
				   Integer res4 = appointmentRequestService.updatestatusByAidMid(appointmentID, memberId, 7);
				   if (res4 <= 0)
					   finres = false;
			   }
			}
			PrintWriter out;
			try {
				out = response.getWriter();
			    out.println(finres);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		}
	}		
	return ;		
    }
	
}
