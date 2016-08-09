package com.kidscodetw.eeit.controller.cust;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.custservice.CustServiceCatagoryDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.custservice.CustServiceCatagoryBean;
import com.kidscodetw.eeit.entity.member.MemberBean;


@Controller
public class CustServiceCatagoryController {
	
	@Autowired
	CustServiceCatagoryDAO custServiceCatagoryDAO;
	

	
	@RequestMapping("custservice")
	public String dispatch(Model model){
		//return "custservice/KF-form.jsp";
		List<CustServiceCatagoryBean> catagoryBeans = custServiceCatagoryDAO.select();
		model.addAttribute("catagory", catagoryBeans);
		return "/custservice/KF-form.jsp";
	}
	
}
