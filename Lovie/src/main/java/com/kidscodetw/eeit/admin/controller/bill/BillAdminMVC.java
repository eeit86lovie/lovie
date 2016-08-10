package com.kidscodetw.eeit.admin.controller.bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class BillAdminMVC {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private TradeDetailDAO tradeDetailDAO;

	@Autowired
	private BillDAO billDAO;

	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping("admin/bill")
	public String dispatch(Model model) {

		Set<Integer> memberIds = new HashSet<Integer>();
		List<BillBean> billBeans = billDAO.select_ALL();
		for (BillBean billBean : billBeans) {
			memberIds.add(billBean.getMemberid());
		}
		//Map<MemberID, TradeCheckoutBean>
		Map<Integer, List<TradeCheckoutBean>> map = new HashMap<Integer, List<TradeCheckoutBean>>();
		for(Integer memberId : memberIds){
			map.put(memberId, memberTradeDetail(memberId));
		}
		List<TradeCheckoutBean> b = map.get(15);
		model.addAttribute("memberIds", memberIds);
		model.addAttribute("checkoutItems", map);
		return "admin/bill/bill.jsp";

	}
	
	
	
	
	
	
	public List<TradeCheckoutBean> memberTradeDetail(Integer memberId){
		MemberBean memberBean = memberDAO.select(memberId);
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
		return tradeCheckoutBeans;
	}
}
