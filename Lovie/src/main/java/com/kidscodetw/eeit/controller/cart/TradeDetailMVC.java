package com.kidscodetw.eeit.controller.cart;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.dao.cart.TradeDetailDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.cart.BillBean;
import com.kidscodetw.eeit.entity.cart.TradeCheckoutBean;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
public class TradeDetailMVC {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BillDAO billDAO;
	
	@Autowired
	private TradeDetailDAO tradeDetailDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("product/queryTrade")
	public String dispatch(Principal principal, Model model){
		
		MemberBean memberBean = memberDAO.select(principal.getName());
		Integer memberId = memberBean.getId();
		List<BillBean> billBeans = billDAO.select_memberid(memberId);
		List<TradeCheckoutBean> tradeCheckoutBeans = new ArrayList<TradeCheckoutBean>();
		for(BillBean billBean: billBeans){
			List<TradeDetailBean> tradeDetailBeans = tradeDetailDAO.select_billid(billBean.getId());
			for(TradeDetailBean tradeDetailBean : tradeDetailBeans){
				TradeCheckoutBean checkout = new TradeCheckoutBean();
				checkout.setMemberid(memberId);
				checkout.setMemberaccount(memberBean.getAccount());
				checkout.setMemberaddress(billBean.getAddress());
				checkout.setMemberphone(billBean.getPhone());
				checkout.setChecktradeTime(billBean.getTradeTime());
				checkout.setProductname(productDAO.select_id(tradeDetailBean.getProductid()).getName());
				checkout.setAmount(tradeDetailBean.getAmount());
				checkout.setTotalcost(tradeDetailBean.getTotalcost());
				tradeCheckoutBeans.add(checkout);
			}
		}
		model.addAttribute("checkoutItems", tradeCheckoutBeans);
		return "product/tradedetail2.jsp";
		
	}
}
