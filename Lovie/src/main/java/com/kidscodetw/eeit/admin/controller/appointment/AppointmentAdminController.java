package com.kidscodetw.eeit.admin.controller.appointment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.service.appointment.AppointmentService2;

@Controller
@RequestMapping("/admin/appointment")
public class AppointmentAdminController {
	@Autowired
	AppointmentService2 appointmentService2;
	
	@RequestMapping("/appointmentjson")
	public @ResponseBody List<AppointmentBean2> selectjson() {
		List<AppointmentBean2> appointment_list = appointmentService2.select();
		return appointment_list;
	}
	

	@RequestMapping("/appointmentRemove")
    public void remove(@RequestParam(value="id",required=false,defaultValue="0") Integer appointmentid,HttpServletResponse response) {
		try {
			Boolean resu = appointmentService2.delete(appointmentid);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(resu);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return;		
	}
	
	@RequestMapping("/appointmentUpdateStatus")
    public void UpdateStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status,HttpServletResponse response) {
		try {
			AppointmentBean2 appointmentBean = appointmentService2.select(id);
			appointmentBean.setStatus(status);
			AppointmentBean2 resu = appointmentService2.update(appointmentBean);
			PrintWriter out;
			try {
				out = response.getWriter();
				if (resu != null)
				   out.println(true);
				else
				   out.println(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return;		
	}
}
