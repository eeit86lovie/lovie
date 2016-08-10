package com.kidscodetw.eeit.admin.controller.custservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.custservice.CustServiceDAO;
import com.kidscodetw.eeit.entity.custservice.CustServiceBean;

@Controller
public class CustServiceServlet {
	
	@Autowired
	private CustServiceDAO custServiceDAO;
	
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
	
		int result = 0;
		
		CustServiceBean csb = new CustServiceBean();
		csb.setMemberId(Member);
		csb.setCatagory(ProblemsNember);
		csb.setMessage(ReportReason);
		csb.setStatus(1);

		if(Member!=null && ProblemsNember !=null && ReportReason != null){
			CustServiceBean custServiceResult = custServiceDAO.insert(csb);	
			result = 1;
		}
			
		
		return result;
	}


	@RequestMapping(value = "admincustService", method = RequestMethod.POST)
	@ResponseBody
	public List<CustServiceBean> adnomSelectreply(){
	
		List<CustServiceBean> Selectresult = custServiceDAO.select();

    return Selectresult;
	}
	
	
	
	@RequestMapping(value = "adminSelectcustService", params = { "ID","REASON"}, method = RequestMethod.POST)
	@ResponseBody
	public CustServiceBean adnomSelect(@RequestParam("ID") Integer ID,@RequestParam("REASON") String REASON){
	
		CustServiceBean result = custServiceDAO.select(ID);
		CustServiceBean bean = new CustServiceBean(); 
		bean.setId(ID);
		bean.setCatagory(result.getCatagory());
		bean.setMemberId(result.getMemberId());
		bean.setMessage(result.getMessage());
		bean.setReplyMessage(REASON);
		bean.setStatus(2);
		
		//System.out.println(bean);
		CustServiceBean Selectresult = custServiceDAO.update(bean);

    return Selectresult;
	}
	
	
}
