package com.kidscodetw.eeit.controller.appointment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("new_appointmentb")
public class NewAppointmentbMVC {

	@RequestMapping(method=RequestMethod.GET)
	public String getAppointments(Model model){
System.out.println("NewAppointmentbMVC...");
		return "appointment/new_appointmentb.jsp";
	}
}
