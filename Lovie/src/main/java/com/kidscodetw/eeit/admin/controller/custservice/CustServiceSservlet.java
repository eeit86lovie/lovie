package com.kidscodetw.eeit.admin.controller.custservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.custservice.CustServiceDAO;

import com.kidscodetw.eeit.entity.custservice.CustServiceBean;

@Controller
public class CustServiceSservlet {
	
//	@Autowired
//	private CustServiceDAO custServiceDAO;
	
	@RequestMapping(value = "custService", method = RequestMethod.GET)
	public String forumJsp1() {
		return "custservice/KF-form";
	}
	
	
	@RequestMapping(value = "custService", params = { "ProblemsNember","Member","ReportReason"}, method = RequestMethod.POST)
	@ResponseBody
	public int addreply(
			@RequestParam("ProblemsNember") Integer ProblemsNember,
			@RequestParam("Member") Integer Member,
			@RequestParam("ReportReason") String ReportReason){
	
		
		System.out.println(ProblemsNember);
	System.out.println(Member);
	System.out.println(ReportReason);
		int result = 1;
		
		CustServiceBean csb = new CustServiceBean();
		csb.setMemberId(Member);
		csb.setCatagory(ProblemsNember);
		csb.setMessage(ReportReason);
		csb.setStatus(1);

		//CustServiceBean custServiceResult = custServiceDAO.insert(csb);	
		//System.out.println(custServiceResult+"sdsdsd");
		return result;
	}
}
