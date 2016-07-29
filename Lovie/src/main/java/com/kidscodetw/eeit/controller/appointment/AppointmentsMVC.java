package com.kidscodetw.eeit.controller.appointment;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.service.appointment.AppointmentService2;

@Controller
public class AppointmentsMVC {
	@Autowired
	AppointmentService2 appointmentService2;
	
	@RequestMapping("appointments")
	public String getAppointments(Model model){

		return "appointment/appointments.jsp";
	}

//	@RequestMapping("/appointmentcaljson/{id}")
	@RequestMapping("/appointmentcaljson")
	public @ResponseBody List<AppointmentsBean> selectjson(
			//@PathVariable("id")Integer memberId,
			@RequestParam(value="start",required=false,defaultValue="2000-01-01") Date showstart,
			@RequestParam(value="end",required=false,defaultValue="2100-01-01") Date showend,
			HttpSession session) {
    	MemberBean bean =  	(MemberBean) session.getAttribute("loginmember");
    	Integer memberId = bean.getId();
		List<AppointmentsBean> appointment_list = appointmentService2.selectcal(memberId, showstart, showend);
		return appointment_list;
	}
	
	@RequestMapping("appointmenta")
	public String getAppointmenta(Model model){

		return "appointment/appointmenta.jsp";
	}

	
	@RequestMapping("appointmentb")
	public String getAppointmentb(Model model){

		return "appointment/appointmentb.jsp";
	}

}
