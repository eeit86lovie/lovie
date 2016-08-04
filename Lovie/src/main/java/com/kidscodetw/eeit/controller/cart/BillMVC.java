package com.kidscodetw.eeit.controller.cart;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.dao.cart.TradeDetailDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.cart.ProductBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.service.member.MemberGetListService;

@Controller
//@RequestMapping("bill")
public class BillMVC {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private TradeDetailDAO tradedetailDAO;
	@Autowired
	private BillDAO billDAO;
	@Autowired
	private MemberDAO memberDAO;

	

	
	
	
	
	
	
	
}
