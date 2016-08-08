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

public class AdminproductMVC {

	@Autowired
	private ProductDAO productDAO;



	
	@RequestMapping(value="productselectid" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ProductBean> select_all() {
		List<ProductBean> lpb = productDAO.select_ALL();
		return lpb;
	}
	
	

	@RequestMapping(value="productinsertid" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ProductBean> insert() {
		List<ProductBean> lpb = productDAO.select_ALL();
		return lpb;
	}
	
	@RequestMapping(value="productupdatetid" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ProductBean> update() {
		List<ProductBean> lpb = productDAO.select_ALL();
		return lpb;
	}
	
	@RequestMapping(value="productdeletetid" ,method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public List<ProductBean> delete() {
		List<ProductBean> lpb = productDAO.select_ALL();
		return lpb;
	}
	
	
	
	
	
	
	
	
}
