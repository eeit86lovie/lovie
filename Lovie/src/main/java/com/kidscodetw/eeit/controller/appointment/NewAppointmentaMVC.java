package com.kidscodetw.eeit.controller.appointment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("new_appointmenta")
public class NewAppointmentaMVC {

	@RequestMapping(method=RequestMethod.GET)
	public String getAppointments(Model model){
System.out.println("NewAppointmentaMVC...");
		return "appointment/new_appointmenta.jsp";
	}
}
