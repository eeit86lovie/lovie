package com.kidscodetw.eeit.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kidscodetw.eeit.dao.cart.ProductDAO;
import com.kidscodetw.eeit.entity.cart.ProductBean;

@Controller
@RequestMapping("memberproduct")
public class MemberProductMVC {

	@Autowired
	private ProductDAO productDAO;

//	@RequestMapping(method = RequestMethod.GET)
//	public String productJsp() {
//		return "product/memberproduct.jsp";
//	}

	// 顯示1~10筆商品
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ProductBean> getList() {
		List<ProductBean> memberproduct = productDAO.select_category(1);
		
		return memberproduct;
		
	}

}
