package com.kidscodetw.eeit.controller.cart;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.dao.cart.TradeDetailDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.cart.BillBean;
import com.kidscodetw.eeit.entity.cart.ProductBean;
import com.kidscodetw.eeit.entity.cart.TradeCheckoutBean;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
public class BillMvc {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private BillDAO billDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private TradeDetailDAO tradeDetailDAO;
	
	@Autowired
	HttpSession session;
	


    @RequestMapping("billCheckout")
	public String getBillData(@RequestParam("username")String username,@RequestParam("address")String address,@RequestParam("phone")String phone,@RequestParam("card")String card, Principal principal,Model model ){
		
    	System.out.println(address);
		MemberBean member = memberDAO.select(principal.getName());
		List<Map<String, Object>> cartlist = (List<Map<String, Object>>) session.getAttribute("addcartlist");
		Integer allTotalCost = new Integer(0);
		List<TradeCheckoutBean> checkoutItems = new ArrayList<TradeCheckoutBean>();
		BillBean billBean = new BillBean();
		billBean.setAddress(address);
		billBean.setCreditnum(card);
		billBean.setPhone(phone);
		billBean.setMemberid(member.getId());
		billBean.setStatus(0);
		BillBean resultBill = billDAO.insert(billBean);
		Integer billId = resultBill.getId();
		for(Map map: cartlist){
			TradeDetailBean tradeDetailBean = new TradeDetailBean();
			ProductBean productBean = (ProductBean)map.get("bean");
			Integer totalCost = (productBean.getCost()*(Integer)map.get("amount"));
			TradeCheckoutBean tradeCheckoutBean=new TradeCheckoutBean();
			tradeDetailBean.setBillid(billId);
			tradeDetailBean.setAmount((Integer)map.get("amount"));
			tradeDetailBean.setProductid(productBean.getProductid());
			tradeDetailBean.setTotalcost(totalCost);
			tradeDetailDAO.insert(tradeDetailBean);
			tradeCheckoutBean.setMemberid(member.getId());
			tradeCheckoutBean.setMemberaccount(member.getAccount());
			tradeCheckoutBean.setMemberaddress(address);
			tradeCheckoutBean.setMemberphone(phone);
			tradeCheckoutBean.setProductname(productBean.getName());
			tradeCheckoutBean.setChecktradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tradeCheckoutBean.setTotalcost(productBean.getCost()*(Integer)map.get("amount"));
			tradeCheckoutBean.setAmount((Integer)map.get("amount"));
			allTotalCost = allTotalCost + totalCost;
			checkoutItems.add(tradeCheckoutBean);
			System.out.println(billBean.getAddress());
		
	}
		model.addAttribute("checkoutItems", checkoutItems);
		model.addAttribute("amount", allTotalCost);
		return "/product/tradedetail.jsp";
	}
	
}		
	

	
	
	
	
	
	
	

