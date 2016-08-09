package com.kidscodetw.eeit.controller.cart;

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
   
	


    @RequestMapping("billCheckout")
	public String getBillData(@RequestParam("username")String username,@RequestParam("address")String address,@RequestParam("phone")int phone,@RequestParam("card")int card, Principal principal, HttpServletRequest request, Model model ){
		System.out.println(principal.getName()); //3122094
		MemberBean member = memberDAO.select(principal.getName());
		System.out.println(member);
		HttpSession session = request.getSession();
		List<Map<String, Object>> cartlist = (List<Map<String, Object>>) session.getAttribute("addcartlist");
		Integer allTotalCost = new Integer(0);
		List<TradeCheckoutBean> checkoutItems = new ArrayList<TradeCheckoutBean>();
		for(Map map: cartlist){
			TradeDetailBean tradeDetailbean = new TradeDetailBean();
			
			
			
			
			BillBean billBean = new BillBean();
			billBean.setAddress(address);
			
			
			
			ProductBean productBean = (ProductBean)map.get("bean");
			System.out.println(productBean);
			System.out.println(map.get("amount"));
			Integer totalCost = (productBean.getCost()*(Integer)map.get("amount"));
			System.out.println(totalCost);
			TradeCheckoutBean tradeCheckoutBean=new TradeCheckoutBean();
			tradeCheckoutBean.setMemberid(member.getId());
			tradeCheckoutBean.setMemberaccount(member.getAccount());
			tradeCheckoutBean.setMemberaddress(address);
			tradeCheckoutBean.setMemberphone(phone);
			tradeCheckoutBean.setProductname(productBean.getName());
			tradeCheckoutBean.setChecktradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			tradeCheckoutBean.setTotalcost(productBean.getCost()*(Integer)map.get("amount"));
			tradeCheckoutBean.setAmount(totalCost);
			allTotalCost = allTotalCost + totalCost;
			checkoutItems.add(tradeCheckoutBean);
		
//		
//		Map<String,Object> all = new HashMap<String,Object>();
//
//		List<BillBean> lbb=billDAO.select_memberid(member.getId());
//		System.out.println(lbb);
//		for(BillBean checkbillBean : lbb){
//		
//			System.out.println(checkbillBean);
//		}
//		all.put("memberid",billBean.getMemberid().toString());
//		all.put("address",allcheckBill.getAddress().toString());
//		all.put("phone",allcheckBill.getPhone().toString());
//		all.put("creditnum",allcheckBill.getCreditnum().toString());
//		all.put("status",allcheckBill.getStatus().toString());
//		all.put("time",allcheckBill.getTradeTime().toString());
		
//		
//		List<TradeDetailBean> allcheckdetail=tradedetailDAO.select_memberid(member.getId());
//		System.out.println(allcheckdetail);
//		all.put("mid",allcheckdetail.getMemberid().toString());
//		all.put("pid",allcheckdetail.getProductid().toString());
//		all.put("totalcost",allcheckdetail.getTotalcost().toString());
//		all.put("amount",allcheckdetail.getAmount().toString());
//		
//		Map<String,Object> last=new HashMap<String,Object>();
//		last.put("all",all);
		
	}
		model.addAttribute("checkoutItems", checkoutItems);
		model.addAttribute("amount", allTotalCost);
		return "/product/tradedetail.jsp";
	}
	
}		
	

	
	
	
	
	
	
	

