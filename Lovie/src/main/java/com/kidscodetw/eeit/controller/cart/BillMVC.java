package com.kidscodetw.eeit.controller.cart;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.cart.BillBean;
import com.kidscodetw.eeit.entity.cart.ProductBean;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;
import com.kidscodetw.eeit.entity.member.MemberBean;

@Controller
@RequestMapping("billCheckout")
public class BillMVC {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private BillDAO billDAO;
	@Autowired
	private MemberDAO memberDAO;


	@RequestMapping(method=RequestMethod.POST)
	public String getBillData(Principal principal, HttpServletRequest request, @RequestParam("username")String username,@RequestParam("address")String address,@RequestParam("phone")int phone,@RequestParam("card")int card) throws Exception{
		System.out.println(principal.getName()); //3122094
		MemberBean member = memberDAO.select(principal.getName());
		member.getId();
		System.out.println(member);
		HttpSession session = request.getSession();
		List<Map<String, Object>> cartlist = (List<Map<String, Object>>) session.getAttribute("addcartlist");
		Integer amount = new Integer(0);
		for(Map map: cartlist){
			ProductBean bean = (ProductBean)map.get("bean");
			
			System.out.println(bean);
			System.out.println(map.get("amount"));
			amount = amount + (bean.getCost()*(Integer)map.get("amount"));
			System.out.println(amount);
	
		TradeDetailBean tradedetailBean=new TradeDetailBean();
		tradedetailBean.setMemberid(member.getId());
		tradedetailBean.setProductid(bean.getProductid());
		tradedetailBean.setAmount((Integer)map.get("amount"));
		tradedetailBean.setTotalcost(amount);
		System.out.println(tradedetailBean);

	
		BillBean billBean=new BillBean();
		billBean.setMemberid(member.getId());
		billBean.setAddress(address);
		billBean.setPhone(phone);
		billBean.setCreditnum(card);
		billBean.setStatus(1);
		billBean.setTradeTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		System.out.println(billBean);
		
		
		
		Map<String,Object> all = new HashMap<String,Object>();

		List<BillBean> lbb=billDAO.select_memberid(member.getId());
		System.out.println(lbb);
		for(BillBean checkbillBean : lbb){
		
			System.out.println(checkbillBean);
		}
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
		return "/product/tradedetail.jsp";
	}
	
}		
	

	
	
	
	
	
	
	

