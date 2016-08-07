package com.kidscodetw.eeit.controller.cart;


import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.dao.cart.ProductDAO;

import com.kidscodetw.eeit.entity.cart.ProductBean;

@Controller
//@RequestMapping("memberproducts")
public class MemberProductMVC {


	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private BillDAO billDAO;



	// 憿舐內����
	@RequestMapping(value="/product/memberproducts/{categoryId}" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ProductBean> getList(@PathVariable("categoryId")Integer categoryId) {
		System.out.println("AAA");
		List<ProductBean> memberProduct = productDAO.select_category(categoryId);
		return memberProduct;
	}
	
	
	//������
	@RequestMapping(value="/product/memberproducts}" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public int delet(@PathVariable("productId")Integer productId) {
		int memberProduct=productDAO.delet(productId);
		return memberProduct;
		
	}
	
	//�憓���
	
}
